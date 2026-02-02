package com.ecommerceapirest.mappers;

import com.ecommerceapirest.dtos.categoryProduct.CategoryProductResponseDTO;
import com.ecommerceapirest.models.CategoryProduct;

public class CategoryProductMapper {

    public static CategoryProductResponseDTO toResponse(CategoryProduct cp) {
        CategoryProductResponseDTO dto = new CategoryProductResponseDTO();

        dto.setId(cp.getId());
        dto.setCategoryId(cp.getCategory().getId());
        dto.setCategoryName(cp.getCategory().getName());
        dto.setProductId(cp.getProduct().getId());
        dto.setProductName(cp.getProduct().getName());

        return dto;
    }
}
