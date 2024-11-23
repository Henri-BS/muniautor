package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.application.exceptions.ResourceNotFoundException;
import com.pasifcode.muniautor.domain.dto.UserDto;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page.map(UserDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        User find = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserDto(find);
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto dto) {

        User add = new User();
        add.setUsername(dto.getUsername());
        add.setEmail(dto.getEmail());
        add.setPassword(dto.getPassword());

        if(userRepository.existsByEmail(add.getEmail())){
            throw new IllegalArgumentException("This email already exists.");
        }

        return new UserDto(userRepository.saveAndFlush(add));
    }
}
