package com.shri.spring.stock.advisor.service;

import com.shri.spring.stock.advisor.dto.StockOrderDto;
import com.shri.spring.stock.advisor.dto.StocksHoldingDetailDto;
import com.shri.spring.stock.advisor.model.StockOrder;
import com.shri.spring.stock.advisor.model.enums.OrderType;
import com.shri.spring.stock.advisor.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public StockOrder createOrder(StockOrderDto stockOrder){
        var so = StockOrder.builder()
                .userId("test_user")
                .quantity(stockOrder.quantity())
                .symbol(stockOrder.symbol())
                .price(stockOrder.price())
                .orderType(stockOrder.orderType())
                .build();
        return orderRepository.save(so);
    }

    public StockOrderDto findById(Long id){
        Optional<StockOrder> stock = orderRepository.findById(id);
        if(stock.isPresent()){
            StockOrder so = stock.get();
            return StockOrderDto.builder()
                    .symbol(so.symbol())
                    .price(so.price())
                    .quantity(so.quantity())
                    .orderType(so.orderType())
                    .build();
        }

        return null;
    }

    public List<StockOrderDto> findAll(){
        List<StockOrder> availableOrders = orderRepository.findAll();
        return availableOrders.stream()
                .map(o -> StockOrderDto.builder()
                        .symbol(o.symbol())
                        .price(o.price())
                        .quantity(o.quantity())
                        .orderType(o.orderType())
                        .build())
                .toList();
    }


    public List<StockOrderDto> getOrdersBySymbol(String symbol){
        List<StockOrder> availableOrders = orderRepository.findBySymbol(symbol);
        return availableOrders.stream()
                .map(o -> StockOrderDto.builder()
                        .symbol(o.symbol())
                        .price(o.price())
                        .quantity(o.quantity())
                        .orderType(o.orderType())
                        .build())
                .toList();
    }

    public List<StocksHoldingDetailDto> getStocksHoldingDetails() {
        return orderRepository.findAll().stream()
                .collect(Collectors.groupingBy(StockOrder::symbol, Collectors.summingInt(o -> Objects.equals(o.orderType(), OrderType.BUY) ? o.quantity() : -o.quantity())))
                .entrySet().stream()
                .map(e -> StocksHoldingDetailDto.builder()
                        .stockSymbol(e.getKey())
                        .quantity(e.getValue().doubleValue())
                        .build())
                .toList();
    }


}
