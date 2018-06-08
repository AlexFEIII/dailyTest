package com.pro.daily.dailyController;

import com.pro.daily.dailyService.SearchService;
import com.pro.daily.domain.DailyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    SearchService searchService;

    @PostMapping("searchDocument")
    public List<DailyDocument> searchDocument(@RequestParam String searchWord){
        return searchService.searchDocument(searchWord);
    }
}
