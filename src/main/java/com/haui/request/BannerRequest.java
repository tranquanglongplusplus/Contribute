package com.haui.request;

import org.springframework.web.multipart.MultipartFile;

public class BannerRequest {

    private String title;

    private MultipartFile image;

    public BannerRequest(){

    }

    public BannerRequest(String title, MultipartFile image){
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
