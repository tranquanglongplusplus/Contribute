package com.haui.request;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {

    private String name;

    private String content;

    private MultipartFile image;

    public ProductRequest(){

    }

    public ProductRequest(String name, String content, MultipartFile image){
        this.name = name;
        this.content = content;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
