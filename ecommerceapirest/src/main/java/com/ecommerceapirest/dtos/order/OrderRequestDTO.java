package com.ecommerceapirest.dtos.order;

import java.math.BigDecimal;

public class OrderRequestDTO {

    private Long userId;
    private String status;       // PENDING, PAID, SHIPPED
    private BigDecimal totalPrice;

    // ===== Getters & Setters =====

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
