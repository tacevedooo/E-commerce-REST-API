package com.ecommerceapirest.repositories;

import com.ecommerceapirest.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    List<OrderProduct> findByOrderId(Long orderId);

    List<OrderProduct> findByProductId(Long productId);

    Optional<OrderProduct> findByOrderIdAndProductId(Long orderId, Long productId);

    void deleteByOrderIdAndProductId(Long orderId, Long productId);

    boolean existsByOrderIdAndProductId(Long orderId, Long productId);
}
