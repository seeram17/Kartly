package com.telusko.Ecommerce.service;

import com.telusko.Ecommerce.model.Product;
import com.telusko.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo  ;

    public List<Product> getProducts(){ return repo.findAll();}

    public Product getProductById(int id) {return repo.findById(id).orElse(null);}

    public Product addProduct(Product product, MultipartFile multipartFile) throws IOException {

        product.setImageName(multipartFile.getOriginalFilename());
        product.setImageType(multipartFile.getContentType());
        product.setImageData(multipartFile.getBytes());

        repo.save(product) ;

        return product ;
    }

    public void updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

        product.setId(id);

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        repo.save(product);
    }

    public void deleteProduct(int id) {

        repo.deleteById(id);

    }

    public List<Product> searchProduct(String keyword) {

        return repo.searchProducts(keyword) ;
    }
}
