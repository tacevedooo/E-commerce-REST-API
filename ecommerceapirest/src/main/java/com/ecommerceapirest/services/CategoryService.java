package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.category.CategoryRequestDTO;
import com.ecommerceapirest.dtos.category.CategoryResponseDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO dto);

    CategoryResponseDTO getCategoryById(@NotNull Long id);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO updateCategory(@NotNull Long id, CategoryRequestDTO dto);

    void deleteCategory(@NotNull Long id);
}
