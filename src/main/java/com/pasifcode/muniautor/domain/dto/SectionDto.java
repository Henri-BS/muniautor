package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Section;

import java.io.Serial;
import java.io.Serializable;

public class SectionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private Long plotId;
    private String plotTitle;
    private Long userId;
    private String username;


    public SectionDto() {
    }

    public SectionDto(Section entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        plotId = entity.getPlot().getId();
        plotTitle = entity.getPlot().getTitle();
        userId = entity.getUser().getId();
        username = entity.getUser().getUsername();
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

    public Long getPlotId() {
        return plotId;
    }

    public String getPlotTitle() {
        return plotTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
