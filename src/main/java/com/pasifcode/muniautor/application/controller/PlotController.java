package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.dto.PlotDto;
import com.pasifcode.muniautor.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plots")
public class PlotController {

    @Autowired
    private PlotService plotService;

    @GetMapping
    public ResponseEntity<Page<PlotDto>> findPlots(Pageable pageable) {
        Page<PlotDto> list = plotService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlotDto> findPlotById(@PathVariable Long id) {
        PlotDto find = plotService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<PlotDto> savePlot(@RequestBody PlotDto dto) {
        PlotDto save = plotService.savePlot(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
