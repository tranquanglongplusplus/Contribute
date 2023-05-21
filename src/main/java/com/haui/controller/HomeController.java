package com.haui.controller;

import com.haui.modal.Banner;
import com.haui.modal.Product;
import com.haui.response.BannerResponse;
import com.haui.response.ProductResponse;
import com.haui.service.BannerService;
import com.haui.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController{

    @Autowired
    private ProductService productService;

    @Autowired
    private BannerService bannerService;

    @GetMapping("/login")
    public String login() { return "login";}

    @GetMapping
    public String getHome(Model model) {
        List<BannerResponse> response = new ArrayList<>();
        List<Banner> list = bannerService.getAllBanner();
        for (int i=0; i<list.size(); i++){
            Banner banner = list.get(i);
            String url = MvcUriComponentsBuilder
                    .fromMethodName(ImageController.class, "getImage", banner.getImage()).build().toString();
            BannerResponse resp = new BannerResponse(i, banner.getTitle(), url, false);
            response.add(resp);
        }
        response.get(0).setActive(true);
        model.addAttribute("list", response);
        return "index";
    }

    @GetMapping("/error")
    public String errorHandle() { return  "error"; }

    @GetMapping("/product/detail")
    public String getProductDetail(){
        return "product-detail";
    }

    @GetMapping("/list-product")
    public String getListProduct(Model model){
        List<ProductResponse> response = new ArrayList<>();
        List<Product> list = productService.getAllProduct();
        list.forEach(product -> {
            String url = MvcUriComponentsBuilder
                    .fromMethodName(ImageController.class, "getImage", product.getImage()).build().toString();
            ProductResponse resp = new ProductResponse(product.getName(), url);
            response.add(resp);
        });
        model.addAttribute("list", response);
        return "product-list";
    }

}
