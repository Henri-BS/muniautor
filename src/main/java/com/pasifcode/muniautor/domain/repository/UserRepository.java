package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}