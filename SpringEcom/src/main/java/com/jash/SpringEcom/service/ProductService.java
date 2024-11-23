package com.jash.SpringEcom.service;

import com.jash.SpringEcom.model.Product;
import com.jash.SpringEcom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> fetchAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> fetchProductById(int id) {
        return productRepo.findById(id);
    }
}
