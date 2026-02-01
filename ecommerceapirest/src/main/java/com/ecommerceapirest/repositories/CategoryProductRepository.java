package com.ecommerceapirest.repositories;

import com.ecommerceapirest.models.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {

}
