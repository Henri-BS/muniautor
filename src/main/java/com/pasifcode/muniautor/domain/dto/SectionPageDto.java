package com.pasifcode.muniautor.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.muniautor.domain.entity.SectionPage;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SectionPageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String body;
    private Long pageNumber;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;
    private Long sectionId;
    private Long userId;
    private String username;

    public SectionPageDto() {
    }

    public SectionPageDto(SectionPage entity) {
        id = entity.getId();
        body = entity.getBody();
        pageNumber = entity.getPageNumber();
        createdDate = entity.getCreatedDate();
        sectionId = entity.getSection().getId();
        userId = entity.getUser().getId();
        username = entity.getUser().getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public Long getUserId() {
        return userId;
    }
}
