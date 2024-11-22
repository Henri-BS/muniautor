package com.pasifcode.muniautor.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.muniautor.domain.entity.Timeline;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class TimelineDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private String epoch;
    private Integer yearNumber;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;
    private Long plotId;
    private Long userId;
    private String username;

    public TimelineDto() {
    }

    public TimelineDto(Timeline entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        epoch = entity.getEpoch();
        yearNumber = entity.getYearNumber();
        createdDate = entity.getCreatedDate();
        plotId = entity.getPlot().getId();
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

    public String getEpoch() {
        return epoch;
    }

    public Integer getYearNumber() {
        return yearNumber;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Long getPlotId() {
        return plotId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
