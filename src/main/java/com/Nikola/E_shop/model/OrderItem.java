package com.Nikola.E_shop.model;

public class OrderItem {
    private Long productId;
    private int quantity;
    private Double priceAtPurchase;

        public OrderItem(){}

    public OrderItem(Long productId,int quantity,Double priceAtPurchase){
        this.productId = productId;
        this.quantity= quantity;
        this.priceAtPurchase = priceAtPurchase;

    }
    public Long getProductId(){
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public void setPriceAtPurchase(Double priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }
}
