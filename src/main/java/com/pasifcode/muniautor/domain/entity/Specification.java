package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "tb_specification")
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specification_id", nullable = false)
    private Long id;

    private String type;

    private String description;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Specification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}