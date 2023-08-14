package com.food.converter.dish;

import com.food.dto.DishDto;
import com.food.entity.Dish;

public interface IDishConverter {
    DishDto convertEntityToDto(Dish dish);

    Dish convertDtoToEntity(DishDto dishDto);
}
