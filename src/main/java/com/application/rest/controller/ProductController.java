package com.application.rest.controller;

import com.application.rest.controller.dto.ProductDTO;
import com.application.rest.persistence.entity.Product;
import com.application.rest.service.ProductService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        
        if(productOptional.isPresent()) {
            Product product = productOptional.get();
            
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductDTO> productsDTO = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build())
                .toList();
        
        return ResponseEntity.ok(productsDTO);
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) 
            throws URISyntaxException {
        
        if(productDTO.getName().isBlank()
                || productDTO.getPrice() == null 
                || productDTO.getMaker() == null)
            return ResponseEntity.badRequest().build();
        
        productService.save(Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build());
        
        return ResponseEntity.created(new URI("/api/products")).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMaker(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {
        
        Optional<Product> productOptional = productService.findById(id);
        
        if(productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setMaker(productDTO.getMaker());
            product.setPrice(productDTO.getPrice());
            productService.save(product);
            return ResponseEntity.ok("Registro actualizado");
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        
        if(id != null) {
            productService.deleteById(id);
            return ResponseEntity.ok("registro eliminado");
        }
        
        return ResponseEntity.badRequest().build();
    }
}
