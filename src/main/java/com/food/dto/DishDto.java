package com.food.dto;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class DishDto {
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than or equal to 0.01")
    private BigDecimal price;
    @NotBlank(message = "Image URL is required")
    private String image;
    @NotNull
    private CategoryDto category;

    private boolean isActive;

    public DishDto(String name, String description, BigDecimal price,
                   String image, boolean isActive) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public DishDto(Long id, String name, String description, BigDecimal price, String image, CategoryDto category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public DishDto(String name, String description, BigDecimal price,
                   String image, CategoryDto category, boolean isActive) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
        this.isActive = isActive;
    }

    public DishDto() {
    }

    public DishDto(String name, String description, BigDecimal price, String image, CategoryDto category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
