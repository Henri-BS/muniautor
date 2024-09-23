package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String email;

    private String password;

    private String image;

    private String bio;

    @OneToMany(mappedBy = "user")
    private Set<Plot> plots = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Section> sections = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Character> characters = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserTag> userTags = new HashSet<>();

    public Set<UserTag> getUserTags() {
        return userTags;
    }

    public void setUserTags(Set<UserTag> userTags) {
        this.userTags = userTags;
    }

    public Set<Section> getChapters() {
        return sections;
    }

    public void setChapters(Set<Section> sections) {
        this.sections = sections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
