package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.categoryProduct.CategoryProductRequestDTO;
import com.ecommerceapirest.dtos.categoryProduct.CategoryProductResponseDTO;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface CategoryProductService {

    CategoryProductResponseDTO assignProductToCategory(CategoryProductRequestDTO dto);

    void removeProductFromCategory(@NotNull Long categoryId, @NotNull Long productId);

    List<CategoryProductResponseDTO> getProductsByCategory(@NotNull Long categoryId);

    List<CategoryProductResponseDTO> getCategoriesByProduct(@NotNull Long productId);
}
