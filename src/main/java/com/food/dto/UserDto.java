package com.food.dto;


import com.food.entity.Role;

public class UserDto {

    private Long id;
    private Role role;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private Boolean activated;


    public UserDto() {
    }

    public UserDto(Long id, Role role, String fullName, String username,
                   String password, String email, String address, String phone,
                  Boolean activated) {
        super();
        this.id = id;
        this.role = role;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.activated = activated;
    }

    public UserDto(Role role, String fullName, String username, String password,
                   String email, String address, String phone,
                   Boolean activated) {
        super();
        this.role = role;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.activated = activated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }


}
