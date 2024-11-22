package com.pasifcode.muniautor.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Plot> plots = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Section> sections = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Character> characters = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Specification> specifications = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<SectionPage> sectionPages = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Plot> getPlots() {
        return plots;
    }

    public Set<Section> getSections() {
        return sections;
    }
}
