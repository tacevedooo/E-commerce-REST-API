package com.ecommerceapirest.services.implementations;

import com.ecommerceapirest.dtos.categoryProduct.CategoryProductRequestDTO;
import com.ecommerceapirest.dtos.categoryProduct.CategoryProductResponseDTO;
import com.ecommerceapirest.mappers.CategoryProductMapper;
import com.ecommerceapirest.models.Category;
import com.ecommerceapirest.models.CategoryProduct;
import com.ecommerceapirest.models.Product;
import com.ecommerceapirest.repositories.CategoryProductRepository;
import com.ecommerceapirest.repositories.CategoryRepository;
import com.ecommerceapirest.repositories.ProductRepository;
import com.ecommerceapirest.services.CategoryProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryProductServiceImpl(
            CategoryProductRepository categoryProductRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {
        this.categoryProductRepository = categoryProductRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CategoryProductResponseDTO assignProductToCategory(CategoryProductRequestDTO dto) {

        if (categoryProductRepository.existsByCategoryIdAndProductId(
                dto.getCategoryId(), dto.getProductId())) {
            throw new RuntimeException("Product already assigned to this category");
        }

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CategoryProduct cp = new CategoryProduct();
        cp.setCategory(category);
        cp.setProduct(product);

        CategoryProduct saved = categoryProductRepository.save(cp);
        return CategoryProductMapper.toResponse(saved);
    }

    @Override
    public void removeProductFromCategory(Long categoryId, Long productId) {

        CategoryProduct cp = categoryProductRepository.findAll()
                .stream()
                .filter(c ->
                        c.getCategory().getId().equals(categoryId) &&
                        c.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Relation not found"));

        categoryProductRepository.delete(cp);
    }

    @Override
    public List<CategoryProductResponseDTO> getProductsByCategory(Long categoryId) {
        return categoryProductRepository.findByCategoryId(categoryId)
                .stream()
                .map(CategoryProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryProductResponseDTO> getCategoriesByProduct(Long productId) {
        return categoryProductRepository.findByProductId(productId)
                .stream()
                .map(CategoryProductMapper::toResponse)
                .collect(Collectors.toList());
    }
}
