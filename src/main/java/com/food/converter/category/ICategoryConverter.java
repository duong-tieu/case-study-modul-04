package com.food.converter.category;

import com.food.dto.CategoryDto;
import com.food.entity.Category;

public interface ICategoryConverter  {

    Category converterToEntity(CategoryDto categoryDto);

    CategoryDto converterToDTO(Category category);
}
