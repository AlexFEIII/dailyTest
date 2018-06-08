package com.pro.daily.dailyController;

import com.pro.daily.dailyService.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("addDocument")
    public String addDocument(@RequestParam String html,
                              @RequestParam String js,
                              @RequestParam String css,
                              @RequestParam String title,
                              @RequestParam String sonTitle,
                              @RequestParam List<String> bigType,
                              @RequestParam String type,
                              @RequestParam String titleimage) throws Exception{
        File file = new File(getClass().getResource("/").getPath());
        File htmlFile = new File(file+File.separator+".."+File.separator+".."+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"templates");
        File staticFile = new File(file+File.separator+".."+File.separator+".."+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static");
        if (documentService.addDocument(html,js,css,htmlFile,staticFile,title,sonTitle,bigType,type,titleimage))
            return "yes";
        else
            return "no";
    }
}
