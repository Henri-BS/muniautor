package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecficationRepository extends JpaRepository<Specification, Long> {
}