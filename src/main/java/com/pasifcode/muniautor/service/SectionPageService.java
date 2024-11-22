package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.SectionPageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SectionPageService {
    Page<SectionPageDto> findAll(Pageable pageable);

    SectionPageDto findById(Long id);

    SectionPageDto saveSectionPage(SectionPageDto dto);
}
