package com.haui.response;

public class ProductManageResponse {
    private int id;

    private String url;

    private String name;

    private String content;

    private String image;

    public ProductManageResponse(){};

    public ProductManageResponse(int id, String url, String name, String content, String image){
        this.id = id;
        this.url = url;
        this.name = name;
        this.content = content;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
