package com.shri.spring.stock.advisor.dto;

import lombok.Builder;

@Builder
public record StocksHoldingDetailDto(String stockSymbol,
                                     Double quantity) {
}
