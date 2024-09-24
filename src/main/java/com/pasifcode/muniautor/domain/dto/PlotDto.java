package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Plot;
import com.pasifcode.muniautor.domain.entity.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class PlotDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String synopsis;
    private String image;
    private UserDto user;

    public PlotDto() {
    }

    public PlotDto(Plot entity) {
        id = entity.getId();
        title = entity.getTitle();
        synopsis = entity.getSynopsis();
        image = entity.getImage();
        user = new UserDto(entity.getUser());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getImage() {
        return image;
    }

    public UserDto getUser() {
        return user;
    }
}
