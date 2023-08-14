package com.food.service;

import com.food.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
  List<CategoryDto> findAll();


  void save(CategoryDto categoryDto);

  Optional<CategoryDto> findById(Long id);

  void deleteById(Long categoryDtoId);
}
