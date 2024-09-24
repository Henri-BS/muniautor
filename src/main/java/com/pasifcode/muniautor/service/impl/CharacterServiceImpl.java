package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.dto.CharacterDto;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.repository.CharacterRepository;
import com.pasifcode.muniautor.domain.repository.PlotRepository;
import com.pasifcode.muniautor.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private PlotRepository plotRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CharacterDto> findByPlot(Plot plot) {
        List<Character> list = characterRepository.findByPlot(plot);
        return list.stream().map(CharacterDto::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CharacterDto findById(Long id) {
        Character find = characterRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new CharacterDto(find);
    }

    @Override
    @Transactional
    public CharacterDto saveCharacter(CharacterDto dto) {
        Plot plot = plotRepository.findById(dto.getPlot().getId())
                .orElseThrow(NoSuchElementException::new);

        Character add = new Character();
        add.setName(dto.getName());
        add.setBio(dto.getBio());
        add.setImage(dto.getImage());
        add.setPlot(plot);

        return new CharacterDto(characterRepository.saveAndFlush(add));
    }
}
