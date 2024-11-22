package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long> {
    List<Timeline> findByPlot(Plot plot);
}