package com.pasifcode.muniautor.domain.dto;

import com.pasifcode.muniautor.domain.entity.SectionPage;

import java.io.Serial;
import java.io.Serializable;

public class SectionPageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String body;
    private Long pageNumber;
    private Long sectionId;
    private Long userId;
    private String username;

    public SectionPageDto() {
    }

    public SectionPageDto(SectionPage entity) {
        id = entity.getId();
        body = entity.getBody();
        pageNumber = entity.getPageNumber();
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

    public void setBody(String body) {
        this.body = body;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
