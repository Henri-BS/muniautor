package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Section;

import java.io.Serial;
import java.io.Serializable;

public class SectionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String body;
    private UserDto user;
    private PlotDto plot;

    public SectionDto() {
    }

    public SectionDto(Section entity) {
        id = entity.getId();
        title = entity.getTitle();
        body = entity.getBody();
        plot = new PlotDto(entity.getPlot());
        user = new UserDto(entity.getUser());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public UserDto getUser() {
        return user;
    }

    public PlotDto getPlot() {
        return plot;
    }
}
