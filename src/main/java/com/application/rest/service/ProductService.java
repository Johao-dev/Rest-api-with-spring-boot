package com.application.rest.service;

import com.application.rest.persistence.entity.Product;
import com.application.rest.service.dto.Range;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);

    List<Product> findByPriceInRange(Range range);
}
