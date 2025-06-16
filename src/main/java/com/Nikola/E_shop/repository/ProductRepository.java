package com.Nikola.E_shop.repository;

import com.Nikola.E_shop.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init (){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dummyjson.com/products";

        JsonResponse response = restTemplate.getForObject(url, JsonResponse.class);
        if (response !=null && response.getProducts() != null){
            products.addAll(response.getProducts());
        }
    }
    public List<Product> findAll(){
        return new ArrayList<>(products);
    }
    public Optional<Product> findById(Long id){
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
