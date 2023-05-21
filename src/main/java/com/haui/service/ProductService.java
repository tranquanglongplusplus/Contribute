package com.haui.service;

import com.haui.modal.Product;
import com.haui.request.ProductRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void load(){
        productList.add(new Product("Fly-cam","", "su-35_0.jpg"));
        productList.add(new Product("Du Lịch","", "Bãi biển Mỹ Khê Đà Nẵng.jpg"));
    }

    public void createNewProduct(ProductRequest request){
        Product newProduct = new Product(request.getName(), request.getContent(), request.getImage().getOriginalFilename());
        productList.add(newProduct);
    }

    public List<Product> getAllProduct(){
        return productList;
    }

}
