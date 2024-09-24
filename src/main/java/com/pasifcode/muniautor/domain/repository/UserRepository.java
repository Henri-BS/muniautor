package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}