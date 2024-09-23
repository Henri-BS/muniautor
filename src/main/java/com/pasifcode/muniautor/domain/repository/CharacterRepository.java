package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}