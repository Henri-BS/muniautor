package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.SectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SectionService {
    Page<SectionDto> findAll(Pageable pageable);

    SectionDto findById(Long id);

    SectionDto saveSection(SectionDto dto);

    SectionDto updateSection(SectionDto dto);
}
