package com.pro.daily.dailyService.impl;

import com.pro.daily.dailyRepository.DocumentRepository;
import com.pro.daily.dailyService.DocumentService;
import com.pro.daily.domain.DailyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public boolean addDocument(String html, String js, String css, File htmlFile, File staticFile,String title,String sonTitle,List<String> bigType,String type,String titleimage) throws Exception {
        List<DailyDocument> dailyDocuments = documentRepository.findAll();
        //取得最大的文章id
        String id = new Integer(dailyDocuments.get(dailyDocuments.size()-1).getId()+1).toString();

        File rHtmlFile = new File(htmlFile+File.separator+id+".html");
        File rJsFile = new File(staticFile+File.separator+"js"+File.separator+id+".js");
        File rCssFile = new File(staticFile+File.separator+"css"+File.separator+id+".css");

        if (!rHtmlFile.exists())rHtmlFile.createNewFile(); //创建文件
        if (!rJsFile.exists()) rJsFile.createNewFile();
        if (!rCssFile.exists()) rCssFile.createNewFile();

        DailyDocument dailyDocument = new DailyDocument(title,sonTitle,titleimage,type);
        for(String s : bigType)
            if (s.equals("long")) dailyDocument.setIslong(true);
            else if (s.equals("tenimage")) dailyDocument.setIstenimage(true);
            else if (s.equals("top15")) dailyDocument.setIstop15(true);
            else if (s.equals("app")) dailyDocument.setIsapp(true);
            else if (s.equals("business")) dailyDocument.setIsbusiness(true);
            else if (s.equals("thought")) dailyDocument.setIsthought(true);
            else if (s.equals("medium")) dailyDocument.setIsmedium(true);
            else dailyDocument.setIsworld(true);
        documentRepository.save(dailyDocument);
        OutputStream outHtml = new FileOutputStream(rHtmlFile);
        outHtml.write(Utf8.encode(html));  //写入html文件
        outHtml.close();
        OutputStream outJs = new FileOutputStream(rJsFile);  //写入js文件
        outJs.write(Utf8.encode(js));
        outJs.close();
        OutputStream outCss = new FileOutputStream(rCssFile);  //写入css文件
        outCss.write(Utf8.encode(css));
        outCss.close();
        return true;
    }
}
