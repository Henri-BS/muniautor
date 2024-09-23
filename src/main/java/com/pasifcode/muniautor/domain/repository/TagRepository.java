package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}