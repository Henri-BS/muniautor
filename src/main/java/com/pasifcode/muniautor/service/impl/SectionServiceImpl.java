package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.dto.SectionDto;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.Section;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.PlotRepository;
import com.pasifcode.muniautor.domain.repository.SectionRepository;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlotRepository plotRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<SectionDto> findAll(Pageable pageable) {
        Page<Section> page = sectionRepository.findAll(pageable);
        return page.map(SectionDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public SectionDto findById(Long id) {
        Section find = sectionRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new SectionDto(find);
    }

    @Override
    @Transactional
    public SectionDto saveSection(SectionDto dto) {
        Plot plot = plotRepository.findById(dto.getPlotId()).orElseThrow(NoSuchElementException::new);
        User user = userRepository.findById(dto.getUserId()).orElseThrow(NoSuchElementException::new);

        Section add = new Section();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setPlot(plot);
        add.setUser(user);

        return new SectionDto(sectionRepository.saveAndFlush(add));
    }

    @Override
    @Transactional
    public SectionDto updateSection(SectionDto dto) {
        Section edit = sectionRepository.findById(dto.getId()).orElseThrow(NoSuchElementException::new);

        edit.setId(edit.getId());
        edit.setTitle(dto.getTitle());
        edit.setDescription(dto.getDescription());

        return new SectionDto(sectionRepository.save(edit));
    }
}
