package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.dto.PlotCatalogDto;
import com.pasifcode.muniautor.service.PlotCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plot-catalogs")
public class PlotCatalogController {

    @Autowired
    private PlotCatalogService plotPlotCatalogService;

    @GetMapping("/{id}")
    public ResponseEntity<PlotCatalogDto> findPlotCatalogById(@PathVariable Long id) {
        PlotCatalogDto find = plotPlotCatalogService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<PlotCatalogDto> savePlotCatalog(@RequestBody PlotCatalogDto dto) {
        PlotCatalogDto save = plotPlotCatalogService.savePlotCatalog(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}