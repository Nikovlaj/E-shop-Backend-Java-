package com.Nikola.E_shop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private Long id;
    @JsonProperty("title")
    private String name;
    private String description;
    private Double price;
    @JsonProperty("thumbnail")
    private String imageUrl;


    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    public Long getId(){
        return  id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public  void  setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}