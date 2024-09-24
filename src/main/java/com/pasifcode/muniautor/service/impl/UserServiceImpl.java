package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.dto.UserDto;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<UserDto> findAllUsers(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page.map(UserDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findUserById(Long id) {
        User find = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new UserDto(find);
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto dto) {

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setImage(dto.getImage());
        user.setBio(dto.getBio());

        return new UserDto(userRepository.saveAndFlush(user));
    }
}
