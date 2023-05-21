package com.haui.response;

public class BannerResponse {
    int id;
    private boolean active;
    private String title;
    private String url;

    public BannerResponse(int id ,String title, String url, boolean active){
        this.id = id;
        this.title = title;
        this.url = url;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
