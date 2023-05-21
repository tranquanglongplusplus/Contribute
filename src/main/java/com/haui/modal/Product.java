package com.haui.modal;

public class Product {

    private String name;
    private String content;
    private String image;

    public Product(){

    }

    public Product(String name, String content, String image){
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
