package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.dto.SpecificationDto;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specifications")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping("/character/{character}")
    public ResponseEntity<List<SpecificationDto>> findByCharacter(@PathVariable Character character) {
        List<SpecificationDto> list = specificationService.findByCharacter(character);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecificationDto> findSpecificationById(@PathVariable Long id) {
        SpecificationDto find = specificationService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<SpecificationDto> saveSpecification(@RequestBody SpecificationDto dto) {
        SpecificationDto save = specificationService.saveSpecification(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SpecificationDto> updateSpecification(@RequestBody SpecificationDto dto) {
        SpecificationDto edit = specificationService.updateSpecification(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }
}
