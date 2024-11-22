package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_section")
public class Section extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    @OneToMany(mappedBy = "section")
    private Set<SectionPage> sectionPages = new HashSet<>();

    public Section() {
    }

    public Section(Long id, String title, String description, LocalDateTime createdDate, User user, Plot plot) {
        super(title, description, createdDate);
        this.id = id;
        this.user = user;
        this.plot = plot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

}