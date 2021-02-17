package com.example.demo.dto;

import java.util.List;

public class RequestPurchaseDTO {

    private List<String> productId;

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(List<String> productId) {
        this.productId = productId;
    }
}
