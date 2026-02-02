package com.ecommerceapirest.controllers;

import com.ecommerceapirest.dtos.category.CategoryRequestDTO;
import com.ecommerceapirest.dtos.category.CategoryResponseDTO;
import com.ecommerceapirest.services.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Create category
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(
            @Valid @RequestBody CategoryRequestDTO dto
    ) {
        CategoryResponseDTO createdCategory =
                categoryService.createCategory(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    //Get category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(
            @PathVariable @NotNull Long id
    ) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    //Get all categories
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    //Update category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable @NotNull Long id,
            @Valid @RequestBody CategoryRequestDTO dto
    ) {
        CategoryResponseDTO updatedCategory =
                categoryService.updateCategory(id, dto);

        return ResponseEntity.ok(updatedCategory);
    }

    //Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(
            @PathVariable @NotNull Long id
    ) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
