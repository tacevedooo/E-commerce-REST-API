package com.ecommerceapirest.mappers;

import com.ecommerceapirest.dtos.category.CategoryRequestDTO;
import com.ecommerceapirest.dtos.category.CategoryResponseDTO;
import com.ecommerceapirest.models.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO dto) {

        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        return category;
    }

    public static CategoryResponseDTO toResponse(Category category) {

        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());

        return dto;
    }
}
