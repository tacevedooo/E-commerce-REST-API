package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.orderProduct.OrderProductRequestDTO;
import com.ecommerceapirest.dtos.orderProduct.OrderProductResponseDTO;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface OrderProductService {

    OrderProductResponseDTO addProductToOrder(OrderProductRequestDTO dto);

    List<OrderProductResponseDTO> getProductsByOrder(@NotNull Long orderId);

    void removeProductFromOrder(@NotNull Long orderId, @NotNull Long productId);
}
