package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.orderProduct.OrderProductRequestDTO;
import com.ecommerceapirest.dtos.orderProduct.OrderProductResponseDTO;

import java.util.List;

public interface OrderProductService {

    OrderProductResponseDTO addProductToOrder(OrderProductRequestDTO dto);

    List<OrderProductResponseDTO> getProductsByOrder(Long orderId);

    void removeProductFromOrder(Long orderId, Long productId);
}
