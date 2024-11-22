package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_section_page")
public class SectionPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_page_id", nullable = false)
    private Long id;

    @Column(length = 5000)
    private String body;

    private Long pageNumber;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SectionPage() {
    }

    public SectionPage(Long id, String body, Long pageNumber) {
        this.id = id;
        this.body = body;
        this.pageNumber = pageNumber;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
