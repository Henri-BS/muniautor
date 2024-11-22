package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.TimelineDto;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.domain.entity.Plot;

import java.util.List;

public interface TimelineService {
    List<TimelineDto> findByPlot(Plot plot);

    TimelineDto findById(Long id);

    TimelineDto saveTimeline(TimelineDto dto);
}
