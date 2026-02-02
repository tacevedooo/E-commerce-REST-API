package com.ecommerceapirest.repositories;

import com.ecommerceapirest.models.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {

    List<CategoryProduct> findByCategoryId(Long categoryId);

    List<CategoryProduct> findByProductId(Long productId);

    boolean existsByCategoryIdAndProductId(Long categoryId, Long productId);

    Optional<CategoryProduct> findByCategoryIdAndProductId(Long categoryId, Long productId);

    void deleteByCategoryIdAndProductId(Long categoryId, Long productId);
}
