package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.product.ProductRequestDTO;
import com.ecommerceapirest.dtos.product.ProductResponseDTO;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO dto);

    ProductResponseDTO getProductById(@NotNull Long id);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO updateProduct(@NotNull Long id, ProductRequestDTO dto);

    void deleteProduct(Long id);
}
