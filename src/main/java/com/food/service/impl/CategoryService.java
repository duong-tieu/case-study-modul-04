package com.food.service.impl;

import com.food.converter.category.ICategoryConverter;
import com.food.dto.CategoryDto;
import com.food.entity.Category;
import com.food.repository.ICategoryRepository;
import com.food.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    private final ICategoryConverter  categoryConverter;

    public CategoryService(ICategoryRepository categoryRepository,ICategoryConverter categoryConverter){
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }


    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryConverter::converterToDTO).toList();
    }

    @Override
    public void save(CategoryDto categoryDto) {
         Category category = categoryConverter.converterToEntity(categoryDto);
         categoryRepository.save(category);
    }

    @Override
    public Optional<CategoryDto> findById(Long id) {
       Optional<Category> categoryOptional = categoryRepository.findById(id);
       return categoryOptional.map(categoryConverter::converterToDTO);
    }

    @Override
    public void deleteById(Long categoryDtoId) {
        categoryRepository.deleteById(categoryDtoId);
    }
}
