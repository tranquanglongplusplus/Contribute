package com.haui.controller;

import com.haui.modal.Banner;
import com.haui.modal.Product;
import com.haui.request.BannerRequest;
import com.haui.request.ProductRequest;
import com.haui.response.BannerResponse;
import com.haui.response.ProductManageResponse;
import com.haui.service.BannerService;
import com.haui.service.ProductService;
import com.haui.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController{

    @Autowired
    private ProductService productService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private StoreFileService storeFileService;

    @GetMapping("/home")
    public String adminHome(Model model){
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

    @GetMapping("/product/create")
    public String getProductForm() { return "product-form"; }

    @GetMapping("/banner/create")
    public String getBannerForm() { return "banner-form"; }

    @PostMapping("/product")
    public String createProduct(@ModelAttribute ProductRequest request, Model model){
        String message = "";
        try {
            productService.createNewProduct(request);
            storeFileService.save(request.getImage());
            if (request.getName().trim().isEmpty()) {
                throw new RuntimeException("product name must not null");
            }
            message = "create product successful";
            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "create product fail" + ". Error: " + e.getMessage();
            model.addAttribute("message", message);
        }
        return "product-form";
    }

    @GetMapping("/product-manage")
    public String listProduct(Model model){
        List<ProductManageResponse> responses = new ArrayList<>();
        List<Product> listProduct = productService.getAllProduct();
        for (int i = 0; i<listProduct.size(); i++){
            Product product = listProduct.get(i);
            String url = MvcUriComponentsBuilder
                    .fromMethodName(ImageController.class, "getImage", product.getImage()).build().toString();
            responses.add(
                    new ProductManageResponse(i+1, url, product.getName(), product.getContent(), product.getImage())
            );
        }
        model.addAttribute("list", responses);
        return "product-manage";
    }

    @GetMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes){
        int productId = id - 1;
        Product deleteProduct = productService.getAllProduct().get(productId);
        try {
            boolean existed = storeFileService.delete(deleteProduct.getImage());
            productService.getAllProduct().remove(productId);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                    "Could not delete Product" + ". Error: " + e.getMessage());
        }
        return "redirect:/admin/product-manage";
    }

    @PostMapping("/banner")
    public String createBanner(@ModelAttribute BannerRequest request, Model model){
        String message = "";
        try {
            bannerService.createNewBanner(request);
            storeFileService.save(request.getImage());
            if (request.getTitle().trim().isEmpty()) {
                throw new RuntimeException("Banner title must not null");
            }
            message = "create Banner successful";
            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "create Banner fail" + ". Error: " + e.getMessage();
            model.addAttribute("message", message);
        }
        return "banner-form";
    }

    @GetMapping("/banner-manage")
    public String listBanner(Model model){
        List<BannerResponse> responses = new ArrayList<>();
        List<Banner> listBanner = bannerService.getAllBanner();
        for (int i = 0; i<listBanner.size(); i++){
            Banner banner = listBanner.get(i);
            String url = MvcUriComponentsBuilder
                    .fromMethodName(ImageController.class, "getImage", banner.getImage()).build().toString();
            BannerResponse resp = new BannerResponse(i + 1, banner.getTitle(), url, false);
            responses.add(resp);
        }
        model.addAttribute("list", responses);
        return "banner-manage";
    }
    @GetMapping("/banner/{id}")
    public String deleteBanner(@PathVariable int id, RedirectAttributes redirectAttributes){
        int bannerId = id;
        Banner deleteBanner = bannerService.getAllBanner().get(bannerId);
        try {
            boolean existed = storeFileService.delete(deleteBanner.getImage());
            bannerService.getAllBanner().remove(bannerId);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                    "Could not delete banner" + ". Error: " + e.getMessage());
        }
        return "redirect:/admin/banner-manage";
    }
}
