package com.pro.daily.dailyService;

import java.io.File;
import java.util.List;

public interface DocumentService {
    public boolean addDocument(String html, String js, String css, File htmlFile, File staticFile, String title, String sonTitle, List<String> bigType, String type, String titleimage) throws Exception;
}
