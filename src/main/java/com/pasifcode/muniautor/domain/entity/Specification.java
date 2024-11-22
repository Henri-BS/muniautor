package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tb_specification")
public class Specification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specification_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Specification() {
    }

    public Specification(Long id, String title, String description, LocalDateTime createdDate, Section section, Character character) {
        super(title, description, createdDate);
        this.id = id;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}