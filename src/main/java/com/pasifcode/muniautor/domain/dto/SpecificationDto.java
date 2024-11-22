package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Specification;

import java.io.Serial;
import java.io.Serializable;

public class SpecificationDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private Long characterId;
    private Long userId;


    public SpecificationDto() {
    }

    public SpecificationDto(Specification entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        characterId = entity.getCharacter().getId();
        userId  = entity.getUser().getId();
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

    public Long getCharacterId() {
        return characterId;
    }

    public Long getUserId() {
        return userId;
    }
}
