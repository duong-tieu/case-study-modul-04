//package com.food.service.impl;
//
//import com.food.entity.User;
//import com.food.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//   @Autowired
//   private IUserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if(user == null){
//              throw new UsernameNotFoundException("User" + username + "was not found in database");
//        }
//
//        List<String> roles =userRepository.findRolesByUsername(username);
//
//        List<GrantedAuthority> authorities =new ArrayList<>();
//        for (String role:roles){
//            GrantedAuthority authority = new SimpleGrantedAuthority(role);
//            authorities.add(authority);
//        }
//
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
//        return userDetails;
//    }
//}
