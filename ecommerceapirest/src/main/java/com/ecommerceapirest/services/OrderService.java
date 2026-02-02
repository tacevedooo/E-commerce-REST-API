package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.order.OrderRequestDTO;
import com.ecommerceapirest.dtos.order.OrderResponseDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO dto);

    OrderResponseDTO getOrderById(@NotNull Long id);

    List<OrderResponseDTO> getAllOrders();

    List<OrderResponseDTO> getOrdersByUserId(@NotNull Long userId);

    OrderResponseDTO updateOrderStatus(@NotNull Long id, String status);

    void deleteOrder(@NotNull Long id);
}
