package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.SectionPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionPageRepository extends JpaRepository<SectionPage, Long> {
}