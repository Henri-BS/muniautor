package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.dto.CatalogDto;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/{id}")
    public ResponseEntity<CatalogDto> findCatalogById(@PathVariable Long id) {
        CatalogDto find = catalogService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<CatalogDto> saveCatalog(@RequestBody CatalogDto dto) {
        CatalogDto save = catalogService.saveCatalog(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CatalogDto> updateCatalog(@RequestBody CatalogDto dto) {
        CatalogDto edit = catalogService.updateCatalog(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }
}
