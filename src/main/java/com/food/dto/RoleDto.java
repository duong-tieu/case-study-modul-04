package com.food.dto;

import java.util.Collection;

public class RoleDto {

    private Long id;
    private String name;
    private String description;

    Collection<UserDto> userDtos;

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

    public Collection<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(Collection<UserDto> userDtos) {
        this.userDtos = userDtos;
    }
}
