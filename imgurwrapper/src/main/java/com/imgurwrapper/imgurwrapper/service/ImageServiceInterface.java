package com.imgurwrapper.imgurwrapper.service;

import com.imgurwrapper.imgurwrapper.entity.ImageUploadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageServiceInterface {

    public ResponseEntity<ImageUploadResponse> uploadImage(MultipartFile file, String authorization,String user);
}
