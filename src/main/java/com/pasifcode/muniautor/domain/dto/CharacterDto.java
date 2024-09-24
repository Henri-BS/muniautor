package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Character;

import java.io.Serial;
import java.io.Serializable;

public class CharacterDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String bio;
    private String image;
    private PlotDto plot;

    public CharacterDto() {
    }

    public CharacterDto(Character entity) {
        id = entity.getId();
        name = entity.getName();
        bio = entity.getBio();
        image = entity.getImage();
        plot = new PlotDto(entity.getPlot());
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

    public PlotDto getPlot() {
        return plot;
    }
}
