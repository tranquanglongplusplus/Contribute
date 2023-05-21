package com.haui.service;

import com.haui.modal.Banner;
import com.haui.request.BannerRequest;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BannerService {

    private List<Banner> list = new ArrayList<>();

    @PostConstruct
    public void load(){
        list.add(new Banner("beach", "beach_1.jpg"));
        list.add(new Banner("bay","beach_2.jpg"));
    }


    public List<Banner> getAllBanner(){
        return list;
    }

    public void createNewBanner(BannerRequest request){
        Banner banner = new Banner(request.getTitle(), request.getImage().getOriginalFilename());
        list.add(banner);
    }
}
