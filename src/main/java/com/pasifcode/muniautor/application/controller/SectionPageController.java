package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.dto.SectionPageDto;
import com.pasifcode.muniautor.service.SectionPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/section-page")
public class SectionPageController {

    @Autowired
    private SectionPageService sectionService;

    @GetMapping
    public ResponseEntity<Page<SectionPageDto>> findSectionPages(Pageable pageable) {
        Page<SectionPageDto> list = sectionService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionPageDto> findSectionPageById(@PathVariable Long id) {
        SectionPageDto find = sectionService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<SectionPageDto> saveSectionPage(@RequestBody SectionPageDto dto) {
        SectionPageDto save = sectionService.saveSectionPage(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
