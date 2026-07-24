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

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {

        try {
            Product prod = service.addProduct(product, imageFile);
            return new ResponseEntity<>(prod, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte []> getProductImageById(@PathVariable int productId){

        Product product = service.getProductById(productId) ;

        byte[] imageData = product.getImageData() ;

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageData);


    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id ,@RequestPart Product product , @RequestPart MultipartFile imageFile ){

        try {
            service.updateProduct(id,product,imageFile);
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed To Update",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){

        service.deleteProduct(id) ;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchByKeyword(@RequestParam String keyword){

        List<Product> products = service.searchProduct(keyword) ;

        return  new ResponseEntity<>(products,HttpStatus.OK);

    }

}