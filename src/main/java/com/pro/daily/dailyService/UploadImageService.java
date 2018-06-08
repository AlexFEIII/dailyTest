package com.pro.daily.dailyService;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
    public String uploadHeadImage(MultipartFile file);
}
