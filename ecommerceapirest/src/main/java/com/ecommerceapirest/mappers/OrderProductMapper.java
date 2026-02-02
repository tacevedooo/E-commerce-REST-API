package com.ecommerceapirest.mappers;

import com.ecommerceapirest.dtos.orderProduct.OrderProductResponseDTO;
import com.ecommerceapirest.models.OrderProduct;

public class OrderProductMapper {

    private OrderProductMapper() {}

    public static OrderProductResponseDTO toResponse(OrderProduct entity) {
        OrderProductResponseDTO dto = new OrderProductResponseDTO();

        dto.setId(entity.getId());
        dto.setOrderId(entity.getOrder().getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setQuantity(entity.getQuantity());
        dto.setPriceAtPurchase(entity.getPriceAtPurchase());

        return dto;
    }
}
