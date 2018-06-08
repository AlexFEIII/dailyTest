package com.pro.daily.dailyController;

import com.pro.daily.dailyRepository.DocumentRepository;
import com.pro.daily.domain.DailyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* 后台管理页面controller
* */
@RestController
public class backController {
    @Autowired
    private DocumentRepository documentRepository;
    /*
    * 返回所有的文章
    * */
    @GetMapping("/backExcel")
    public List<DailyDocument> getExcel(){
        return documentRepository.findAll();
    }
}
