package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Plot;

import java.io.Serial;
import java.io.Serializable;

public class PlotDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private String image;
    private Long userId;
    private String username;

    public PlotDto() {
    }

    public PlotDto(Plot entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        image = entity.getImage();
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

    public String getImage() {
        return image;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
