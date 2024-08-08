package com.example.web.controller;

import com.example.web.model.entity.Product;
import com.example.web.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestParam MultipartFile[] images,
                              @RequestParam Map<String, String> params) throws IOException {
        try {
            return productService.addProduct(images, params);
        } catch (Exception e) {
            // Xử lý lỗi, trả về thông báo lỗi hoặc mã lỗi
            log.error("Error adding product", e);
            throw new RuntimeException("Error adding product");
        }
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

}