package com.pasifcode.muniautor.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.muniautor.domain.entity.Character;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CharacterDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String bio;
    private String image;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;
    private Long plotId;
    private String plotTitle;
    private Long userId;
    private String username;

    public CharacterDto() {
    }

    public CharacterDto(Character entity) {
        id = entity.getId();
        name = entity.getName();
        bio = entity.getBio();
        image = entity.getImage();
        createdDate = entity.getCreatedDate();
        plotId = entity.getPlot().getId();
        plotTitle = entity.getPlot().getTitle();
        userId = entity.getUser().getId();
        username = entity.getUser().getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
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
