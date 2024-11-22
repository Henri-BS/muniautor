package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_timeline")
public class Timeline extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeline_id", nullable = false)
    private Long id;

    private String epoch;

    private Integer yearNumber;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Timeline() {
    }

    public Timeline(Long id, String title, String description, LocalDateTime createdDate, String epoch, Integer yearNumber, Plot plot, User user) {
        super(title, description, createdDate);
        this.id = id;
        this.epoch = epoch;
        this.yearNumber = yearNumber;
        this.plot = plot;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public Integer getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(Integer yearNumber) {
        this.yearNumber = yearNumber;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeline timeline = (Timeline) o;
        return Objects.equals(id, timeline.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}