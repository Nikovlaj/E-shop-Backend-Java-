package com.Nikola.E_shop.repository;

import com.Nikola.E_shop.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orders = new HashMap<>();
    private long nextOrderId = 1;

    public Order save(Order order){
        order.setId(nextOrderId);
        orders.put(nextOrderId, order);
        nextOrderId++;
        return order;
    }
    public Optional<Order> findById(Long id){
        return Optional.ofNullable(orders.get(id));
    }
}
