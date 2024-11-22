package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.dto.CharacterDto;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterDto>> findByPlot(Plot plot) {
        List<CharacterDto> list = characterService.findByPlot(plot);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> findCharacterById(Long id) {
        CharacterDto find = characterService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<CharacterDto> saveCharacter(@RequestBody CharacterDto dto) {
        CharacterDto save = characterService.saveCharacter(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CharacterDto> updateCharacter(@RequestBody CharacterDto dto) {
        CharacterDto edit = characterService.updateCharacter(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }
}
