package com.ecommerceapirest.controllers;

import com.ecommerceapirest.dtos.order.OrderRequestDTO;
import com.ecommerceapirest.dtos.order.OrderResponseDTO;
import com.ecommerceapirest.services.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Create order
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(
            @Valid @RequestBody OrderRequestDTO dto
    ) {
        OrderResponseDTO createdOrder = orderService.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    //Get order by id
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(
            @PathVariable @NotNull Long id
    ) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    //Get all orders
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    //Get orders by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponseDTO>> getOrdersByUser(
            @PathVariable @NotNull Long userId
    ) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    //Update order status
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponseDTO> updateOrderStatus(
            @PathVariable @NotNull Long id,
            @RequestParam @NotBlank String status
    ) {
        OrderResponseDTO updatedOrder =
                orderService.updateOrderStatus(id, status);

        return ResponseEntity.ok(updatedOrder);
    }

    //Delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(
            @PathVariable @NotNull Long id
    ) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
