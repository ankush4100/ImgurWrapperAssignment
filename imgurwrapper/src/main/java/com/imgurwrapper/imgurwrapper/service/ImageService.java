package com.imgurwrapper.imgurwrapper.service;

import com.imgurwrapper.imgurwrapper.entity.ImageUploadResponse;
import com.imgurwrapper.imgurwrapper.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 * Image service.
 */
@Service
@Slf4j
public class ImageService implements ImageServiceInterface, Constants {
    /**
     * User profile service object.
     */
    @Autowired
    UserProfileServiceInterface userProfileService;

    RestTemplate restTemplate;
    /**
     * Url to upload image.
     */
    @Value("${uplaod.image.url}")
    private  String uploadimageUrl;

    /**
     * Method to upload image to imgur.
     * @param file
     * @param authorization
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<ImageUploadResponse> uploadImage( final MultipartFile file, final String authorization, final String user)  {

        restTemplate=new RestTemplate();
        ResponseEntity<ImageUploadResponse> response=null;

       try {
           if(userProfileService.validateuser(user)!=null) {
               final HttpHeaders headers = new HttpHeaders();
               final byte[] encodedBytes = Base64.encodeBase64(file.getBytes());
               headers.set(AUTHORIZATION, authorization);
               final MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
               map.add("image", encodedBytes);
               map.add("name", file.getOriginalFilename());

               final HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

               response = restTemplate.postForEntity(uploadimageUrl, request, ImageUploadResponse.class);
           }else{

               response=new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
           }

       }catch (final Exception e){
           log.error(e.getMessage());
       }
return response;
    }




}
