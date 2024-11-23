package com.jash.SpringEcom.controller;

import com.jash.SpringEcom.model.Product;
import com.jash.SpringEcom.repo.ProductRepo;
import com.jash.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello boiss";
    }

    @GetMapping("/products")
    public List<Product> fetchAllProducts() {
        return productService.fetchAllProducts();
    }

    @GetMapping("/allproducts")
    public ResponseEntity<List<Product>> fetchAllProductsResponseEntity() {
        return new ResponseEntity<>(productService.fetchAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> fetchProductById(@PathVariable("id") int id) {
        Product product = productService.fetchProductById(id).orElse(null);

        if(Objects.nonNull(product)) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
