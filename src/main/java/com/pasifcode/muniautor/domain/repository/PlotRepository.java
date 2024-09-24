package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
}