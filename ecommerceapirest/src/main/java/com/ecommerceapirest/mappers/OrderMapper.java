package com.ecommerceapirest.mappers;

import com.ecommerceapirest.dtos.order.OrderRequestDTO;
import com.ecommerceapirest.dtos.order.OrderResponseDTO;
import com.ecommerceapirest.models.Order;
import com.ecommerceapirest.models.User;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto, User user) {

        Order order = new Order();
        order.setUser(user);
        order.setStatus(dto.getStatus());
        order.setTotalPrice(dto.getTotalPrice());

        return order;
    }

    public static OrderResponseDTO toResponse(Order order) {

        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setStatus(order.getStatus());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setCreatedAt(order.getCreatedAt());

        return dto;
    }
}
