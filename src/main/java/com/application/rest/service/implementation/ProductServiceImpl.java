package com.application.rest.service.implementation;

import com.application.rest.persistence.entity.Product;
import com.application.rest.persistence.repository.ProductRepository;
import com.application.rest.service.ProductService;
import com.application.rest.service.dto.Range;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByPriceInRange(Range range) {
        return productRepository.findProductByPriceInRange(range.getMinValue(), range.getMaxValue());
    }
}
