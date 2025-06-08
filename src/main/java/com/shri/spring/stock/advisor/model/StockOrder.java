package com.shri.spring.stock.advisor.model;

import com.shri.spring.stock.advisor.model.enums.OrderType;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Table
public record StockOrder(
        @Id Long id,
        String userId,
        String symbol,
        Integer quantity,
        BigDecimal price,
        OrderType orderType,
        @CreatedDate Timestamp createdAt
){}
