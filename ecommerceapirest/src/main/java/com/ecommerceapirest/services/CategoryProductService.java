package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.categoryProduct.CategoryProductRequestDTO;
import com.ecommerceapirest.dtos.categoryProduct.CategoryProductResponseDTO;

import java.util.List;

public interface CategoryProductService {

    CategoryProductResponseDTO assignProductToCategory(CategoryProductRequestDTO dto);

    void removeProductFromCategory(Long categoryId, Long productId);

    List<CategoryProductResponseDTO> getProductsByCategory(Long categoryId);

    List<CategoryProductResponseDTO> getCategoriesByProduct(Long productId);
}
