package com.pro.daily.dailyService.impl;

import com.google.gson.Gson;
import com.pro.daily.dailyRepository.UserPackageRepository.UserRepository;
import com.pro.daily.dailyService.UploadImageService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class UploadImageServiceImpl implements UploadImageService {
    public String uploadHeadImage(MultipartFile file){
        File localFile = null;
        try{
            localFile = File.createTempFile("tmp",null);
            file.transferTo(localFile);
            localFile.deleteOnExit();
        }catch (IOException e){
            e.printStackTrace();
        }
        Configuration configuration = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(configuration);
        String ACCESS_KEY = "M7uC-qZnrZ75l9uEnC1CjB7csC7gR4T3LseKGB9r";
        String SECRET_KEY="LuwbyZvXZRtCslhaPxUwm4PFtn0mOgwsBlHOQ6ME";
        String buckename = "daily-space";
        String key = getImageName();
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(buckename);
        try{
            Response response = uploadManager.put(localFile,key,upToken);
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        }catch (QiniuException ex){
            Response r = ex.response;
            try{
                System.err.println(r.bodyString());
            }catch (QiniuException ex2){}
        }
        return key;
    }

    public String getImageName(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss-");
        String str = simpleDateFormat.format(new Date());
        int randNum = new Random(10000).nextInt();
        return new StringBuilder(str).append(String.valueOf(randNum)).toString();
    }
}
