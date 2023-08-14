package com.food.dto;

import java.util.List;

public class CategoryDto {
    private Long id;

    private String name;

    private List<DishDto> dishDtos;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String name, List<DishDto> dishDtos) {
        this.id = id;
        this.name = name;
        this.dishDtos = dishDtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DishDto> getDishDtos() {
        return dishDtos;
    }

    public void setDishDtos(List<DishDto> dishDtos) {
        this.dishDtos = dishDtos;
    }
}
