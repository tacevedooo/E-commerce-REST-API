package com.ecommerceapirest.services.implementations;

import com.ecommerceapirest.dtos.order.OrderRequestDTO;
import com.ecommerceapirest.dtos.order.OrderResponseDTO;
import com.ecommerceapirest.mappers.OrderMapper;
import com.ecommerceapirest.models.Order;
import com.ecommerceapirest.models.User;
import com.ecommerceapirest.repositories.OrderRepository;
import com.ecommerceapirest.repositories.UserRepository;
import com.ecommerceapirest.services.OrderService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = OrderMapper.toEntity(dto, user);
        Order savedOrder = orderRepository.save(order);

        return OrderMapper.toResponse(savedOrder);
    }

    @Override
    public OrderResponseDTO getOrderById(@NotNull Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return OrderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public List<OrderResponseDTO> getOrdersByUserId(@NotNull Long userId) {

        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getUser().getId().equals(userId))
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponseDTO updateOrderStatus(@NotNull Long id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        Order updated = orderRepository.save(order);

        return OrderMapper.toResponse(updated);
    }

    @Override
    public void deleteOrder(@NotNull Long id) {

        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }

        orderRepository.deleteById(id);
    }
}
