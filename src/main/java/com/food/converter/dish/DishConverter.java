package com.food.converter.dish;

import com.food.dto.DishDto;
import com.food.entity.Dish;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DishConverter implements IDishConverter{
    @Override
    public DishDto convertEntityToDto(Dish dish) {
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);
        return dishDto;
    }

    @Override
    public Dish convertDtoToEntity(DishDto dishDto) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto,dish);
        return dish;
    }
}
