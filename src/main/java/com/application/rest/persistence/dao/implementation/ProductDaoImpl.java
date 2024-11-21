package com.application.rest.persistence.dao.implementation;

import com.application.rest.persistence.dao.ProductDAO;
import com.application.rest.persistence.entity.Product;
import com.application.rest.persistence.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements ProductDAO {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepo.findProductByPriceInRange(minPrice, maxPrice);
    }
}
