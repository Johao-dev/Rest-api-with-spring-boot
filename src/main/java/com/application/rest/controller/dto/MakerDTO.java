package com.application.rest.controller.dto;

import com.application.rest.persistence.entity.Product;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class MakerDTO {
    
    private Long id;
    private String name;
    private List<Product> products;
}
