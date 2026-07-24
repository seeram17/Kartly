package com.telusko.Ecommerce.controller;


import com.telusko.Ecommerce.model.Product;
import com.telusko.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service  ;

    @RequestMapping("/")
    public String greet(){ return "Hello World";}

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        Product product = service.getProductById(id) ;

        if(product==null) return new ResponseEntity<>(product,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
    }

}