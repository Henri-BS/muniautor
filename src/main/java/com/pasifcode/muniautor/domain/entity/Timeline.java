package com.pasifcode.muniautor.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_timeline")
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeline_id", nullable = false)
    private Long id;

    @Column(length = 80, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String epoch;

    private Integer yearNumber;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;


}