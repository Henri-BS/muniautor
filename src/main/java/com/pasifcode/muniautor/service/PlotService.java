package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.PlotDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface PlotService {
    Page<PlotDto> findAll(Pageable pageable);

    PlotDto findById(Long id);

    PlotDto savePlot(PlotDto dto);

    @Transactional
    PlotDto updatePlot(PlotDto dto);
}
