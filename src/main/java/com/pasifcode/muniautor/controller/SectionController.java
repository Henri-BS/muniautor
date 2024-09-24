package com.pasifcode.muniautor.controller;

import com.pasifcode.muniautor.domain.dto.SectionDto;
import com.pasifcode.muniautor.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public ResponseEntity<Page<SectionDto>> findSections(Pageable pageable) {
        Page<SectionDto> list = sectionService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionDto> findSectionById(@PathVariable Long id) {
        SectionDto find = sectionService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<SectionDto> saveSection(@RequestBody SectionDto dto) {
        SectionDto save = sectionService.saveSection(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
