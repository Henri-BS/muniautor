package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.dto.SpecificationDto;
import com.pasifcode.muniautor.domain.entity.*;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.domain.repository.CharacterRepository;
import com.pasifcode.muniautor.domain.repository.SpecificationRepository;
import com.pasifcode.muniautor.domain.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository characterRepository;

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
        Character character = characterRepository.findById(dto.getCharacterId()).orElseThrow(NoSuchElementException::new);
        User user = userRepository.findById(dto.getUserId()).orElseThrow(NoSuchElementException::new);

        Specification add = new Specification();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setCharacter(character);
        add.setUser(user);

        return new SpecificationDto(specificationRepository.saveAndFlush(add));
    }

    @Override
    @Transactional
    public SpecificationDto updateSpecification(SpecificationDto dto) {
        Specification edit = specificationRepository.findById(dto.getId()).orElseThrow(NoSuchElementException::new);

        edit.setId(edit.getId());
        edit.setTitle(dto.getTitle());
        edit.setDescription(dto.getDescription());

        return new SpecificationDto(specificationRepository.save(edit));
    }
}
