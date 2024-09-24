package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.dto.TimelineDto;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.Timeline;
import com.pasifcode.muniautor.domain.repository.CharacterRepository;
import com.pasifcode.muniautor.domain.repository.PlotRepository;
import com.pasifcode.muniautor.domain.repository.TimelineRepository;
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
    private CharacterRepository characterRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TimelineDto> findByPlot(Plot plot) {
        List<Timeline> list = timelineRepository.findByPlot(plot);
        return list.stream().map(TimelineDto::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TimelineDto> findByCharacter(Character character) {
        List<Timeline> list = timelineRepository.findByCharacter(character);
        return list.stream().map(TimelineDto::new).toList();

    }

    @Override
    public TimelineDto findById(Long id) {
        Timeline find = timelineRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new TimelineDto(find);
    }

    @Override
    public TimelineDto saveTimeline(TimelineDto dto) {
        Plot plot = plotRepository.findById(dto.getPlot().getId()).orElseThrow(NoSuchElementException::new);
        Character character = characterRepository.findById(dto.getCharacter().getId()).orElseThrow(NoSuchElementException::new);

        Timeline add = new Timeline();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setEpoch(dto.getEpoch());
        add.setYearNumber(dto.getYearNumber());
        add.setPlot(plot);
        add.setCharacter(character);
        return new TimelineDto(timelineRepository.saveAndFlush(add));

    }
}
