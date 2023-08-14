package com.food.converter.User;

import com.food.dto.UserDto;
import com.food.entity.User;

public interface UserConverter {

    User converterToEntity(UserDto userDto);

    UserDto converterToDto(User user);

    Iterable<UserDto> converterToDtoList(Iterable<User> users);

}
