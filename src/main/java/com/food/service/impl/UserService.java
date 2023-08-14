package com.food.service.impl;

import com.food.converter.User.UserConverter;
import com.food.dto.RoleDto;
import com.food.dto.UserDto;

import com.food.entity.User;
import com.food.repository.IUserRepository;
import com.food.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@ComponentScan("com.food")
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
       return user.map(userConverter::converterToDto);
    }

    @Override
    public void save(UserDto userDto) {

    }

//    @Override
//    public void save(UserDto userDto) {
//       User user = userConverter.converterToEntity(userDto);
//       if(!userDto.getPassword().isEmpty()){
//           String hashedPassword = BCrypt.hashpw(userDto.getPassword(),BCrypt.gensalt(10));
//           user.setPassword(hashedPassword);
//       }
//       userRepository.save(user);
//    }

    @Override
    public void remove(Long id) {
       userRepository.deleteById(id);
    }


    @Override
    public Iterable<UserDto> findAllByRole(RoleDto roleDto) {
        Iterable<User> users = userRepository.findAllByRole(roleDto);
        return userConverter.converterToDtoList(users);
    }

    @Override
    public Iterable<UserDto> findAll() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(),true)
                .map(user -> userConverter.converterToDto(user)).collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
       Page<User> userPage = userRepository.findAll(pageable);
       return userPage.map(userConverter::converterToDto);
    }

    @Override
    public Page<UserDto> findAllByFullNameContaining(String fullName, Pageable pageable) {
        Page<User> userPage = userRepository.findAllByFullNameContaining(fullName, pageable);
        List<UserDto> dtos =new ArrayList<>(
                userPage.stream().parallel()
                        .map(user -> userConverter.converterToDto(user)).collect(Collectors.toList()));
                return new PageImpl<>(dtos);

    }

}
