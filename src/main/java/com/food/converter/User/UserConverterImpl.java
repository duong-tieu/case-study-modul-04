package com.food.converter.User;

import com.food.dto.UserDto;
import com.food.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public User converterToEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }

    @Override
    public UserDto converterToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public Iterable<UserDto> converterToDtoList(Iterable<User> users) {
        Iterable<UserDto> userDtoIterable = new ArrayList<>();
        BeanUtils.copyProperties(users,userDtoIterable);
        return userDtoIterable;
    }
}
