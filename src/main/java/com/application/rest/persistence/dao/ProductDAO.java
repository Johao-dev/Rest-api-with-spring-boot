package com.application.rest.persistence.dao;

import com.application.rest.persistence.entity.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
