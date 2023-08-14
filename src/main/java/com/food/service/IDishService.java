package com.food.service;

import com.food.dto.DishDto;

import com.food.entity.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDishService {
    Page<DishDto> findAll(Pageable pageable);

    Page<DishDto> findByName(String name,Pageable pageable);

    void save(DishDto dishDto);

    Optional<DishDto> findById(Long id);

    void deleteById(Long dishDtoId);

    List<DishDto> findAllNotPage();
}
