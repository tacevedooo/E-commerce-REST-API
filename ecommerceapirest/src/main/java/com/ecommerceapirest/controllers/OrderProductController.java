package com.ecommerceapirest.controllers;

import com.ecommerceapirest.dtos.orderProduct.OrderProductRequestDTO;
import com.ecommerceapirest.dtos.orderProduct.OrderProductResponseDTO;
import com.ecommerceapirest.services.OrderProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    /**
     * Add a product to an order
     */
    @PostMapping
    public ResponseEntity<OrderProductResponseDTO> addProductToOrder(
            @Valid @RequestBody OrderProductRequestDTO dto) {

        OrderProductResponseDTO response =
                orderProductService.addProductToOrder(dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Get all products of an order
     */
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderProductResponseDTO>> getProductsByOrder(
            @PathVariable @NotNull Long orderId) {

        List<OrderProductResponseDTO> products =
                orderProductService.getProductsByOrder(orderId);

        return ResponseEntity.ok(products);
    }

    /**
     * Remove a product from an order
     */
    @DeleteMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<Void> removeProductFromOrder(
            @PathVariable @NotNull Long orderId,
            @PathVariable @NotNull Long productId) {

        orderProductService.removeProductFromOrder(orderId, productId);

        return ResponseEntity.noContent().build();
    }
}
