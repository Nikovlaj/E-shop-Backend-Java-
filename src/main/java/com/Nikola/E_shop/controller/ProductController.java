package com.Nikola.E_shop.controller;

import com.Nikola.E_shop.Service.ProductService;
import com.Nikola.E_shop.exception.ResourceNotFoundException;
import com.Nikola.E_shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

@Autowired
    public ProductController(ProductService productService){
    this.productService = productService;
}
@GetMapping
    public List<Product> getAllProducts(){
    return productService.getAllProducts();
}
@GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
    return productService.getProductById(id);

}
}

