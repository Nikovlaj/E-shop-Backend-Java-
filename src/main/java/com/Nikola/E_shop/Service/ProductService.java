package com.Nikola.E_shop.Service;

import com.Nikola.E_shop.exception.ResourceNotFoundException;
import com.Nikola.E_shop.model.Product;
import com.Nikola.E_shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product","id", id));
    }
}
