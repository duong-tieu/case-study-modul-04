package com.food.controller;

import com.food.dto.CategoryDto;
import com.food.dto.DishDto;
import com.food.service.ICategoryService;
import com.food.service.IDishService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/dish")

public class DishController {

    private final IDishService dishService;

    private final ICategoryService categoryService;


    public DishController(IDishService dishService,ICategoryService categoryService){
        this.dishService = dishService;
        this.categoryService = categoryService;
    }


    @GetMapping("/list-dish")
    public ResponseEntity<?> List(){
       List<?> dishDtoList = dishService.findAllNotPage();
       return new ResponseEntity<>(dishDtoList, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ModelAndView listDish(Pageable pageable,@RequestParam(value = "search",required = false) String name){
        Page<DishDto> dishesDto;
        if (name != null){
            dishesDto = dishService.findByName(name,pageable);
        } else {
            dishesDto = dishService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/dish/list");
        modelAndView.addObject("dishes",dishesDto);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        List<CategoryDto> categoryDtos = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("dish/create");
        modelAndView.addObject("dishDto",new DishDto());
        modelAndView.addObject("category",categoryDtos);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveNew(@ModelAttribute("dishDto") DishDto dishDto){
        dishDto.setActive(true);
        dishService.save(dishDto);
        ModelAndView modelAndView = new ModelAndView("/dish/create");
        modelAndView.addObject("dishDto",new DishDto());
        modelAndView.addObject("message","new create dish successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id){
        Optional<DishDto> dishDto = dishService.findById(id);
        ModelAndView modelAndView;
        if(dishDto.isPresent()){
           modelAndView = new ModelAndView("/dish/edit");
           modelAndView.addObject("dishDto",dishDto.get());
        } else {
            modelAndView = new ModelAndView("/404");
        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateDish(@ModelAttribute("dishDto") DishDto dishDto){
       dishService.save(dishDto);
       ModelAndView modelAndView = new ModelAndView("/dish/edit");
       modelAndView.addObject("message","edit is successfully");
       return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id){
        Optional<DishDto> dishDto = dishService.findById(id);
        ModelAndView modelAndView;
        if(dishDto.isPresent()){
            modelAndView = new ModelAndView("/dish/delete");
            modelAndView.addObject("dishDto",dishDto.get());
//            modelAndView.addObject("image",image);
        } else {
            modelAndView = new ModelAndView("/404");
        }
        return modelAndView;
    }

    @PostMapping("delete")
    public String delete(@ModelAttribute("dishDto") DishDto dishDto){
        dishService.deleteById(dishDto.getId());
        return "redirect:list";
    }


}
