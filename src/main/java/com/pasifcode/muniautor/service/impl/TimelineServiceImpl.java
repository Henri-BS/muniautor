package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.application.exceptions.ResourceNotFoundException;
import com.pasifcode.muniautor.domain.dto.TimelineDto;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.Timeline;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.PlotRepository;
import com.pasifcode.muniautor.domain.repository.TimelineRepository;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    private TimelineRepository timelineRepository;

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TimelineDto> findByPlot(Plot plot) {
        List<Timeline> list = timelineRepository.findByPlot(plot);
        return list.stream().map(TimelineDto::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TimelineDto findById(Long id) {
        Timeline find = timelineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new TimelineDto(find);
    }

    @Override
    @Transactional
    public TimelineDto saveTimeline(TimelineDto dto) {
        Plot plot = plotRepository.findById(dto.getPlotId()).orElseThrow(() -> new ResourceNotFoundException(dto.getPlotId()));
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(dto.getUserId()));

        Timeline add = new Timeline();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setEpoch(dto.getEpoch());
        add.setYearNumber(dto.getYearNumber());
        add.setPlot(plot);
        add.setUser(user);

        return new TimelineDto(timelineRepository.saveAndFlush(add));
    }

    @Override
    @Transactional
    public TimelineDto updateTimeline(TimelineDto dto) {
        Timeline edit = timelineRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(dto.getId()));

        edit.setId(edit.getId());
        edit.setTitle(dto.getTitle());
        edit.setDescription(dto.getDescription());
        edit.setEpoch(dto.getEpoch());
        edit.setYearNumber(dto.getYearNumber());

        return new TimelineDto(timelineRepository.save(edit));
    }
}
