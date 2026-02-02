package com.ecommerceapirest.dtos.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderResponseDTO {

    private Long id;
    private Long userId;
    private String status;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
