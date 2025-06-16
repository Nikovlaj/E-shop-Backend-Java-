package com.Nikola.E_shop.repository;

import com.Nikola.E_shop.model.Product;

import java.util.List;

public class JsonResponse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
