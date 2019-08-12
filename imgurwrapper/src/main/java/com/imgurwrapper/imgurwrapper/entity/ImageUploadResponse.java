package com.imgurwrapper.imgurwrapper.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageUploadResponse {
    private ImageData data;
    private String success;
    private String status;

}
