package com.ecommerceapirest.controllers;

import com.ecommerceapirest.dtos.categoryProduct.CategoryProductRequestDTO;
import com.ecommerceapirest.dtos.categoryProduct.CategoryProductResponseDTO;
import com.ecommerceapirest.services.CategoryProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category-products")
public class CategoryProductController {

    private final CategoryProductService categoryProductService;

    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    /**
     * Assign a product to a category
     */
    @PostMapping
    public ResponseEntity<CategoryProductResponseDTO> assignProductToCategory(
            @Valid @RequestBody CategoryProductRequestDTO dto) {

        CategoryProductResponseDTO response =
                categoryProductService.assignProductToCategory(dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Remove a product from a category
     */
    @DeleteMapping("/category/{categoryId}/product/{productId}")
    public ResponseEntity<Void> removeProductFromCategory(
            @PathVariable @NotNull Long categoryId,
            @PathVariable @NotNull Long productId) {

        categoryProductService.removeProductFromCategory(categoryId, productId);

        return ResponseEntity.noContent().build();
    }

    /**
     * Get all products of a category
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CategoryProductResponseDTO>> getProductsByCategory(
            @PathVariable @NotNull Long categoryId) {

        List<CategoryProductResponseDTO> products =
                categoryProductService.getProductsByCategory(categoryId);

        return ResponseEntity.ok(products);
    }

    /**
     * Get all categories of a product
     */
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CategoryProductResponseDTO>> getCategoriesByProduct(
            @PathVariable @NotNull Long productId) {

        List<CategoryProductResponseDTO> categories =
                categoryProductService.getCategoriesByProduct(productId);

        return ResponseEntity.ok(categories);
    }
}
