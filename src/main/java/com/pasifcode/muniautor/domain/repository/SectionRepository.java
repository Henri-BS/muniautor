package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}