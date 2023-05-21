package com.haui;

import com.haui.service.StoreFileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class HauiShopApplication implements CommandLineRunner {

    @Resource
    StoreFileService storageService;

    public static void main(String[] args) {
        SpringApplication.run(HauiShopApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
        storageService.init();
    }

}
