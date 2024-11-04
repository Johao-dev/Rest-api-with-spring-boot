package com.application.rest.service;

import com.application.rest.persistence.entity.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    
    List<Product> findAll();
    
    Optional<Product> findById(Long id);
    
    void save(Product product);
    
    void deleteById(Long id);
    
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
