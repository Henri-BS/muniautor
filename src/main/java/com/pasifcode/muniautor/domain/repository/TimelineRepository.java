package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineRepository extends JpaRepository<Timeline, Long> {
}