package com.shri.spring.stock.advisor.model;

import com.shri.spring.stock.advisor.model.enums.OrderType;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Table(schema = "portfolio", name = "stock_orders")
public record StockOrder(
        @Id Long id,
        String userId,
        String symbol,
        Integer quantity,
        BigDecimal price,
        OrderType orderType,
        @CreatedDate LocalDateTime createdAt
){}
