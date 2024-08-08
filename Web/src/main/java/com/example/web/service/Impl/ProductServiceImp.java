package com.example.web.service.Impl;


import com.example.web.model.entity.Product;
import com.example.web.model.entity.ProductImage;
import com.example.web.repository.ProductImageRepository;
import com.example.web.repository.ProductRepository;
import com.example.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public Product addProduct(MultipartFile[] images, Map<String, String> params) throws IOException {

        final String path = "C:\\Users\\teocaothu\\Desktop\\Shop_Vip_web\\Web\\src\\main\\resources\\upload\\";

        Product newProd = new Product();

        String title = params.get("title");
        String price = params.get("price");
        String description = params.get("description");

        newProd.setTitle(title);
        newProd.setPrice(Long.parseLong(price));
        newProd.setDescription(description);

        productRepository.save(newProd);

        List<ProductImage> listImages = new ArrayList<>();
        for (MultipartFile productImage : images) {
            ProductImage newImage = new ProductImage();
            // lưu vật lí
            String pathImg = path + productImage.getOriginalFilename();
            productImage.transferTo(new File(pathImg));

            newImage.setName(productImage.getOriginalFilename());
            newImage.setLink(pathImg);
            newImage.setProduct(newProd);

            listImages.add(newImage);
            productImageRepository.save(newImage);
        }

        newProd.setImages(listImages);
        return newProd;

    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }


}