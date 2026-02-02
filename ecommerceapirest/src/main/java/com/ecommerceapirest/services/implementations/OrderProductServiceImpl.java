package com.ecommerceapirest.services.implementations;

import com.ecommerceapirest.dtos.orderProduct.OrderProductRequestDTO;
import com.ecommerceapirest.dtos.orderProduct.OrderProductResponseDTO;
import com.ecommerceapirest.mappers.OrderProductMapper;
import com.ecommerceapirest.models.Order;
import com.ecommerceapirest.models.OrderProduct;
import com.ecommerceapirest.models.Product;
import com.ecommerceapirest.repositories.OrderProductRepository;
import com.ecommerceapirest.repositories.OrderRepository;
import com.ecommerceapirest.repositories.ProductRepository;
import com.ecommerceapirest.services.OrderProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderProductServiceImpl(
            OrderProductRepository orderProductRepository,
            OrderRepository orderRepository,
            ProductRepository productRepository
    ) {
        this.orderProductRepository = orderProductRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderProductResponseDTO addProductToOrder(OrderProductRequestDTO dto) {

        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);
        orderProduct.setQuantity(dto.getQuantity());
        orderProduct.setPriceAtPurchase(dto.getPriceAtPurchase());

        OrderProduct saved = orderProductRepository.save(orderProduct);

        return OrderProductMapper.toResponse(saved);
    }

    @Override
    public List<OrderProductResponseDTO> getProductsByOrder(Long orderId) {

        return orderProductRepository.findByOrderId(orderId)
                .stream()
                .map(OrderProductMapper::toResponse)
                .toList();
    }

    @Override
    public void removeProductFromOrder(Long orderId, Long productId) {
        orderProductRepository.deleteByOrderIdAndProductId(orderId, productId);
    }
}
