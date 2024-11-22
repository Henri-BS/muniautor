package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.SpecificationDto;
import com.pasifcode.muniautor.domain.entity.Character;

import java.util.List;

public interface SpecificationService {

    List<SpecificationDto> findByCharacter(Character character);

    SpecificationDto findById(Long id);

    SpecificationDto saveSpecification(SpecificationDto dto);

    SpecificationDto updateSpecification(SpecificationDto dto);
}
