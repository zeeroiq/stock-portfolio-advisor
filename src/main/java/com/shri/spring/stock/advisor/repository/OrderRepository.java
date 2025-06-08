package com.shri.spring.stock.advisor.repository;

import com.shri.spring.stock.advisor.model.StockOrder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<StockOrder, Long> {
    List<StockOrder> findBySymbol(String symbol);
}
