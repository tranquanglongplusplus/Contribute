package com.haui.modal;

public class Banner {
    private String title;
    private String image;

    public Banner(){

    }

    public Banner(String title, String image){
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
