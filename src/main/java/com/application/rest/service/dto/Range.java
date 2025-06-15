package com.application.rest.service.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class Range {

    @PositiveOrZero
    private BigDecimal minValue;

    @Positive
    @Min(value = 10)
    @Max(value = 1000)
    private BigDecimal maxValue;
}
