package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.dto.SpecificationDto;
import com.pasifcode.muniautor.domain.entity.*;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.domain.repository.CharacterRepository;
import com.pasifcode.muniautor.domain.repository.SectionRepository;
import com.pasifcode.muniautor.domain.repository.SpecificationRepository;
import com.pasifcode.muniautor.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationRepository specificationRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SpecificationDto> findBySection(Section section) {
        List<Specification> list = specificationRepository.findBySection(section);
        return list.stream().map(SpecificationDto::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SpecificationDto> findByCharacter(Character character) {
        List<Specification> list = specificationRepository.findByCharacter(character);
        return list.stream().map(SpecificationDto::new).toList();

    }

    @Override
    @Transactional(readOnly = true)
    public SpecificationDto findById(Long id) {
        Specification find = specificationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new SpecificationDto(find);
    }

    @Override
    @Transactional
    public SpecificationDto saveSpecification(SpecificationDto dto) {
        Section section = sectionRepository.findById(dto.getSection().getId()).orElseThrow(NoSuchElementException::new);
        Character character = characterRepository.findById(dto.getCharacter().getId()).orElseThrow(NoSuchElementException::new);

        Specification add = new Specification();
        add.setType(dto.getType());
        add.setDescription(dto.getDescription());
        add.setSection(section);
        add.setCharacter(character);

        return new SpecificationDto(specificationRepository.saveAndFlush(add));
    }
}
