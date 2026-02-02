package com.ecommerceapirest.mappers;

import com.ecommerceapirest.dtos.product.ProductRequestDTO;
import com.ecommerceapirest.dtos.product.ProductResponseDTO;
import com.ecommerceapirest.models.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setActive(dto.getActive() != null ? dto.getActive() : true);
        return product;
    }

    public static ProductResponseDTO toResponse(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setActive(product.getActive());
        dto.setCreatedAt(product.getCreatedAt());
        return dto;
    }
}
