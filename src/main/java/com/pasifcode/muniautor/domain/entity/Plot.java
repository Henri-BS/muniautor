package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_plot")
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plot_id", nullable = false)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    private String image;

    @OneToMany(mappedBy = "plot")
    private Set<Timeline> timeline = new HashSet<>();

    @OneToMany(mappedBy = "plot")
    private Set<Section> sections = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Plot() {
    }

    public Plot(Long id, String title, String synopsis, String image) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Timeline> getTimeline() {
        return timeline;
    }

    public Set<Section> getSections() {
        return sections;
    }
}