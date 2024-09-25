package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.dto.TimelineDto;
import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.Section;
import com.pasifcode.muniautor.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timelines")
public class TimelineController {

    @Autowired
    private TimelineService timelineService;

    @GetMapping("/plot/{plot}")
    public ResponseEntity<List<TimelineDto>> findByPlot(@PathVariable Plot plot) {
        List<TimelineDto> list = timelineService.findByPlot(plot);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/character/{character}")
    public ResponseEntity<List<TimelineDto>> findByCharacter(@PathVariable Character character) {
        List<TimelineDto> list = timelineService.findByCharacter(character);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimelineDto> findTimelineById(@PathVariable Long id) {
        TimelineDto find = timelineService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<TimelineDto> saveTimeline(@RequestBody TimelineDto dto) {
        TimelineDto save = timelineService.saveTimeline(dto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
