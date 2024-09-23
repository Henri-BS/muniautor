package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false)
    private Long id;

    private String type;

    @Column(nullable = false)
    private String description;


    @OneToMany(mappedBy = "tag")
    private Set<UserTag> userTags = new HashSet<>();

    @OneToMany(mappedBy = "tag")
    private Set<PlotTag> plotTags = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserTag> getUserTags() {
        return userTags;
    }

    public Set<PlotTag> getPlotTags() {
        return plotTags;
    }
}