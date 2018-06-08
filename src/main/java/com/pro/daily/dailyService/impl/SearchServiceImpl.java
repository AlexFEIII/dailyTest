package com.pro.daily.dailyService.impl;

import com.pro.daily.dailyRepository.DocumentRepository;
import com.pro.daily.dailyService.SearchService;
import com.pro.daily.domain.DailyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private DocumentRepository documentRepository;

    public List<DailyDocument> searchDocument(String searchWord){
        return documentRepository.findByTitleLikeOrSontitleLike("%"+searchWord+"%","%"+searchWord+"%");
    }
}
