package com.shri.spring.stock.advisor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shri.spring.stock.advisor.model.enums.OrderType;
import lombok.Builder;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public record StockOrderDto(
        String symbol,
        Integer quantity,
        BigDecimal price,
        OrderType orderType,
        String currentMarketPrice
){}
