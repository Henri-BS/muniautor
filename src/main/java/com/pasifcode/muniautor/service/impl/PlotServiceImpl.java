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
    public PlotDto saveUser(PlotDto dto) {
        User user = userRepository.findById(dto.getUser().getId())
                .orElseThrow(NoSuchElementException::new);

        Plot plot = new Plot();
        plot.setTitle(dto.getTitle());
        plot.setSynopsis(dto.getSynopsis());
        plot.setImage(dto.getImage());
        plot.setUser(user);

        return new PlotDto(plotRepository.saveAndFlush(plot));
    }
}
