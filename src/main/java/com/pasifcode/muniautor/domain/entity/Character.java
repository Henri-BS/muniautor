package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id", nullable = false)
    private Long id;

    private String name;
    private String bio;
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "character")
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "character")
    private Set<Timeline> timelines = new HashSet<>();



}