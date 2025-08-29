package com.fatec.hello.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.hello.entities.Product;
import com.fatec.hello.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
         return repository.findById(id).orElseThrow( ()-> new EntityNotFoundException("Produto não cadastrado"));
    }
}