package com.food.converter.category;

import com.food.dto.CategoryDto;
import com.food.entity.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements ICategoryConverter {

    @Override
    public Category converterToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto,category);
        return category;
    }

    @Override
    public CategoryDto converterToDTO(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category,categoryDto);
        return categoryDto;
    }
}
