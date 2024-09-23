package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTagRepository extends JpaRepository<UserTag, Long> {
}