package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.CharacterDto;
import com.pasifcode.muniautor.domain.entity.Plot;

import java.util.List;

public interface CharacterService {
    List<CharacterDto> findByPlot(Plot plot);

    CharacterDto findById(Long id);

    CharacterDto saveCharacter(CharacterDto dto);
}
