package com.pro.daily.dailyService;

import com.pro.daily.domain.DailyDocument;

import java.util.List;

public interface SearchService {
    public List<DailyDocument> searchDocument(String searchWord);
}
