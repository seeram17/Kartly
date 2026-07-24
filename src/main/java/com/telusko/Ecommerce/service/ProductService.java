package com.telusko.Ecommerce.service;

import com.telusko.Ecommerce.model.Product;
import com.telusko.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo  ;

    public List<Product> getProducts(){ return repo.findAll();}
}
