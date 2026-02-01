package com.ecommerceapirest.repositories;

import com.ecommerceapirest.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}