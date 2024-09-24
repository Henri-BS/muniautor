package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.User;

import java.io.Serial;
import java.io.Serializable;

public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String email;
    private String password;
    private String image;
    private String bio;

    public UserDto() {
    }

    public UserDto(User entity) {
        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();
        password = entity.getPassword();
        image = entity.getImage();
        bio = entity.getBio();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public String getBio() {
        return bio;
    }
}
