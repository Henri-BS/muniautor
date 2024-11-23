package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.PlotCatalogDto;
import org.springframework.transaction.annotation.Transactional;

public interface PlotCatalogService {
    @Transactional(readOnly = true)
    PlotCatalogDto findById(Long id);

    @Transactional
    PlotCatalogDto savePlotCatalog(PlotCatalogDto dto);
}
