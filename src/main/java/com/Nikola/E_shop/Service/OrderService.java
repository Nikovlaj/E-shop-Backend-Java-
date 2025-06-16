package com.Nikola.E_shop.Service;

import com.Nikola.E_shop.exception.ResourceNotFoundException;
import com.Nikola.E_shop.model.Order;
import com.Nikola.E_shop.model.OrderItem;
import com.Nikola.E_shop.model.Product;
import com.Nikola.E_shop.repository.OrderRepository;
import com.Nikola.E_shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    public Order createOrder(Order order){
        double total = 0.0;
        if (order.getItems() == null || order.getItems().isEmpty()){
            throw new IllegalArgumentException("Ordern måste innehålla en produkt");
        }
        for (OrderItem item : order.getItems()){
            Optional<Product> productOpt = productRepository.findById(item.getProductId());
            if (productOpt.isEmpty()){
                throw new ResourceNotFoundException("Produkt med ID" + item.getProductId() + "Finns inte");
            }
            Product product = productOpt.get();
            double price = product.getPrice();
            item.setPriceAtPurchase(price);

            total += price * item.getQuantity();

        }
        order.setTotalAmount(total);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }
}
