package org.example.ps27852_lab5.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab5.entity.Product;
import org.example.ps27852_lab5.repository.ProductRepository;
import org.example.ps27852_lab5.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public List<Product> findByCategoryId(Integer cid) {
        return List.of();
    }

    @Override
    public void deleteProduct(Integer id) {

    }

    @Override
    public Product updateProduct(Product product, Integer id) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }
}
