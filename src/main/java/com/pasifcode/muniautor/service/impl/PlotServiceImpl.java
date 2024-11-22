package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.dto.PlotDto;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.PlotRepository;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class PlotServiceImpl implements PlotService {

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<PlotDto> findAll(Pageable pageable) {
        Page<Plot> page = plotRepository.findAll(pageable);
        return page.map(PlotDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public PlotDto findById(Long id) {
        Plot find = plotRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new PlotDto(find);
    }

    @Override
    @Transactional
    public PlotDto savePlot(PlotDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(NoSuchElementException::new);

        Plot add = new Plot();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setImage(dto.getImage());
        add.setUser(user);

        return new PlotDto(plotRepository.saveAndFlush(add));
    }
}
