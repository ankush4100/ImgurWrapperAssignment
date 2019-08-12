package com.imgurwrapper.imgurwrapper.controller;

import com.imgurwrapper.imgurwrapper.Dao.entity.UserProfile;
import com.imgurwrapper.imgurwrapper.entity.ImageUploadResponse;
import com.imgurwrapper.imgurwrapper.service.ImageServiceInterface;
import com.imgurwrapper.imgurwrapper.service.UserProfileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * This Class is controller.
 */
@RestController
@RequestMapping("/wrapper")
public class Controller {

    /**
     * Register Service.
     */
    @Autowired
    UserProfileServiceInterface registerService;
    /**
     *Image Service.
     */
    @Autowired
    ImageServiceInterface ImageService;
    /**
     *Api to registerUser.
     */
    @PostMapping(value = "/registerUser")
    public UserProfile registerUser(@RequestBody final UserProfile user) {
        return registerService.registerUser(user);

    }


    /**
     *Api to Upload Image.
     */
    @PostMapping(value = "/uploadImage/{user}")
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestBody final MultipartFile file,@PathVariable("user") final String user, @RequestHeader final String authorization) {

        return   ImageService.uploadImage(file, authorization,user);


    }




}
