package com.ecommerceapirest.services.implementations;

import com.ecommerceapirest.dtos.category.CategoryRequestDTO;
import com.ecommerceapirest.dtos.category.CategoryResponseDTO;
import com.ecommerceapirest.mappers.CategoryMapper;
import com.ecommerceapirest.models.Category;
import com.ecommerceapirest.repositories.CategoryRepository;
import com.ecommerceapirest.services.CategoryService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {

        Category category = CategoryMapper.toEntity(dto);
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.toResponse(savedCategory);
    }

    @Override
    public CategoryResponseDTO getCategoryById(@NotNull Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return CategoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponseDTO updateCategory(@NotNull Long id, CategoryRequestDTO dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        Category updatedCategory = categoryRepository.save(category);

        return CategoryMapper.toResponse(updatedCategory);
    }

    @Override
    public void deleteCategory(@NotNull Long id) {

        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }

        categoryRepository.deleteById(id);
    }
}
