package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.Specification;

import java.io.Serial;
import java.io.Serializable;

public class SpecificationDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String type;
    private String description;
    private SectionDto section;
    private CharacterDto character;

    public SpecificationDto() {
    }

    public SpecificationDto(Specification entity) {
        id = entity.getId();
        type = entity.getType();
        description = entity.getDescription();
        section = new SectionDto(entity.getSection());
        character = new CharacterDto(entity.getCharacter());
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public SectionDto getSection() {
        return section;
    }

    public CharacterDto getCharacter() {
        return character;
    }
}
