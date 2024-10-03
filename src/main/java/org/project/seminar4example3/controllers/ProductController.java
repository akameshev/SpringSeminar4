package org.project.seminar4example3.controllers;

import lombok.AllArgsConstructor;
import org.project.seminar4example3.models.Product;
import org.project.seminar4example3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService service;

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products",service.getProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        service.addProduct(p);
        model.addAttribute("products",service.getProducts());
        return "products";
    }
}
