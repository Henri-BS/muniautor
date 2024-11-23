package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.application.exceptions.ResourceNotFoundException;
import com.pasifcode.muniautor.domain.dto.PlotCatalogDto;
import com.pasifcode.muniautor.domain.entity.Catalog;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.PlotCatalog;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.CatalogRepository;
import com.pasifcode.muniautor.domain.repository.PlotCatalogRepository;
import com.pasifcode.muniautor.domain.repository.PlotRepository;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.PlotCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class PlotCatalogServiceImpl implements PlotCatalogService {

    @Autowired
    private PlotCatalogRepository plotCatalogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    @Transactional(readOnly = true)
    public PlotCatalogDto findById(Long id) {
        PlotCatalog find = plotCatalogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new PlotCatalogDto(find);
    }

    @Override
    @Transactional
    public PlotCatalogDto savePlotCatalog(PlotCatalogDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(dto.getUserId()));
        Plot plot = plotRepository.findByTitle(dto.getPlotTitle());
        Catalog catalog = catalogRepository.findById(dto.getCatalogId()).orElseThrow(() -> new ResourceNotFoundException(dto.getCatalogId()));


        PlotCatalog add = new PlotCatalog();
        add.setPlot(plot);
        add.setCatalog(catalog);
        add.setUser(user);

        return new PlotCatalogDto(plotCatalogRepository.saveAndFlush(add));
    }
}
