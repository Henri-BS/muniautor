package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Timeline;

import java.io.Serial;
import java.io.Serializable;

public class TimelineDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private String epoch;
    private Integer yearNumber;
    private PlotDto plot;
    private CharacterDto character;

    public TimelineDto() {
    }

    public TimelineDto(Timeline entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        epoch = entity.getEpoch();
        yearNumber = entity.getYearNumber();
        plot = new PlotDto(entity.getPlot());
        character = new CharacterDto(entity.getCharacter());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEpoch() {
        return epoch;
    }

    public Integer getYearNumber() {
        return yearNumber;
    }

    public PlotDto getPlot() {
        return plot;
    }

    public CharacterDto getCharacter() {
        return character;
    }
}
