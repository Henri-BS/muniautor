package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.application.exceptions.ResourceNotFoundException;
import com.pasifcode.muniautor.domain.dto.SectionPageDto;
import com.pasifcode.muniautor.domain.entity.Section;
import com.pasifcode.muniautor.domain.entity.SectionPage;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.SectionPageRepository;
import com.pasifcode.muniautor.domain.repository.SectionRepository;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.SectionPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class SectionPageServiceImpl implements SectionPageService {

    @Autowired
    private SectionPageRepository sectionPageRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<SectionPageDto> findAll(Pageable pageable) {
        Page<SectionPage> page = sectionPageRepository.findAll(pageable);
        return page.map(SectionPageDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public SectionPageDto findById(Long id) {
        SectionPage find = sectionPageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new SectionPageDto(find);
    }

    @Override
    @Transactional
    public SectionPageDto saveSectionPage(SectionPageDto dto) {
        Section section = sectionRepository.findById(dto.getSectionId()).orElseThrow(() -> new ResourceNotFoundException(dto.getSectionId()));
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(dto.getUserId()));

        SectionPage add = new SectionPage();
        add.setBody(dto.getBody());
        add.setPageNumber(dto.getPageNumber());
        add.setSection(section);
        add.setUser(user);

        return new SectionPageDto(sectionPageRepository.saveAndFlush(add));
    }

    @Override
    @Transactional
    public SectionPageDto updateSectionPage(SectionPageDto dto) {
        SectionPage edit = sectionPageRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(dto.getId()));

        edit.setId(edit.getId());
        edit.setBody(dto.getBody());
        edit.setPageNumber(dto.getPageNumber());

        return new SectionPageDto(sectionPageRepository.save(edit));
    }
}
