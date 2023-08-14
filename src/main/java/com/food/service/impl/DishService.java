package com.food.service.impl;

import com.food.converter.dish.IDishConverter;
import com.food.dto.DishDto;
import com.food.entity.Dish;
import com.food.repository.IDishRepository;
import com.food.service.IDishService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService implements IDishService {

    private final IDishRepository dishRepository;

    private final IDishConverter dishConverter;

    public DishService(IDishRepository dishRepository,IDishConverter dishConverter){
        this.dishRepository = dishRepository;
        this.dishConverter = dishConverter;
    }

    @Override
    public Page<DishDto> findAll(Pageable pageable) {
        Page<Dish> dishes = dishRepository.findAll(pageable);
        return dishes.map(dishConverter::convertEntityToDto);
    }

    @Override
    public Page<DishDto> findByName(String name,Pageable pageable) {
        Page<Dish> dishes = dishRepository.findByNameContaining(name,pageable);
        return dishes.map(dishConverter::convertEntityToDto);
    }

    @Override
    public void save(DishDto dishDto) {
        Dish dish = dishConverter.convertDtoToEntity(dishDto);
        dishRepository.save(dish);
    }


    @Override
    public Optional<DishDto> findById(Long id) {
        Optional<Dish> dishOptional = dishRepository.findById(id);
        return  dishOptional.map(dishConverter :: convertEntityToDto);
    }
    @Override
    public void deleteById(Long dishDtoId) {
        dishRepository.softDeleteById(dishDtoId);
    }

    @Override
    public List<DishDto> findAllNotPage() {
        List<Dish> dishes = dishRepository.findAll();
        return dishes.stream().map(dishConverter::convertEntityToDto).toList();
    }


}
