package com.application.rest.controller.dto;

import com.application.rest.persistence.entity.Maker;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class ProductDTO {
    
    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
