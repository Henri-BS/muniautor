package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserDto> findAllUsers(Pageable pageable);

    UserDto findUserById(Long id);

    UserDto saveUser(UserDto dto);
}
