package com.Nikola.E_shop.ServiceTest;

import com.Nikola.E_shop.Service.OrderService;
import com.Nikola.E_shop.model.CustomerInfo;
import com.Nikola.E_shop.model.Order;
import com.Nikola.E_shop.model.OrderItem;
import com.Nikola.E_shop.model.Product;
import com.Nikola.E_shop.repository.OrderRepository;
import com.Nikola.E_shop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    private OrderService orderService;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;


    private static class TestProductRepository extends ProductRepository {
        private final Map<Long, Product> products = new HashMap<>();

        public void addProduct(Product product) {
            products.put(product.getId(), product);
        }

        @Override
        public Optional<Product> findById(Long id) {
            return Optional.ofNullable(products.get(id));
        }

        @Override
        public List<Product> findAll() {
            return new ArrayList<>(products.values());
        }
    }

    private static class TestOrderRepository extends OrderRepository {
        private final Map<Long, Order> orders = new HashMap<>();
        private long currentId = 1;

        @Override
        public Order save(Order order) {
            order.setId(currentId++);
            orders.put(order.getId(), order);
            return order;
        }
    }

    @BeforeEach
    public void setup() {
        productRepository = new TestProductRepository();
        orderRepository = new TestOrderRepository();
        orderService = new OrderService(orderRepository, productRepository);

        ((TestProductRepository) productRepository).addProduct(
                new Product(1L, "Testprodukt", "Beskrivning", 100.0, "Bild.jpg")
        );
    }

    @Test
    public void testCreateOrder_Success() {
        OrderItem orderItem = new OrderItem(1L, 2, null);
        CustomerInfo customerInfo = new CustomerInfo("Anna", "Blåsvägen 2", "Anna.exempel@example.com");

        Order order = new Order();
        order.setCustomerInfo(customerInfo);
        order.setItems(List.of(orderItem));

        Order savedOrder = orderService.createOrder(order);

        assertNotNull(savedOrder.getId());
        assertEquals(200.0, savedOrder.getTotalAmount());
        assertNotNull(savedOrder.getOrderDate());
    }

    @Test
    public void testCreateOrder_ProductNotFound() {
        OrderItem orderItem = new OrderItem(910L, 1, null);
        CustomerInfo customer = new CustomerInfo("Lars", "Skolagatan 5", "lars@exempel.se");

        Order order = new Order();
        order.setCustomerInfo(customer);
        order.setItems(List.of(orderItem));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrder(order);
        });

        assertTrue(exception.getMessage().contains("Produkt med ID910"));
    }
}
