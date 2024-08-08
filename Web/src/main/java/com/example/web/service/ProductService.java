package com.example.web.service;

import com.example.web.model.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.Map;
import java.util.Optional;

public interface ProductService {

    Product addProduct(MultipartFile[] images, Map<String, String> params) throws IOException;

    Optional<Product> getById(Integer id);

}
