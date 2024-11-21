package com.application.rest.persistence.repository;

import com.application.rest.persistence.entity.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // query method
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // con anotacion @Query
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
