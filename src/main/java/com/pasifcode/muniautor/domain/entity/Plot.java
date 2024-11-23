package com.pasifcode.muniautor.domain.entity;

import com.pasifcode.muniautor.domain.key.PlotCatalogPk;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_plot")
public class Plot extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plot_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "plot")
    private Set<Timeline> timelines = new HashSet<>();

    @OneToMany(mappedBy = "plot")
    private Set<Section> sections = new HashSet<>();

    @OneToMany(mappedBy = "plot")
    private Set<Character> characters = new HashSet<>();

    @OneToMany(mappedBy = "id.plot")
    private Set<PlotCatalog> plotCatalog = new HashSet<>();

    public Plot() {
    }

    public Plot(Long id, String title, String description, String image, LocalDateTime createdDate) {
        super(title, description, image, createdDate);
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plot plot = (Plot) o;
        return Objects.equals(id, plot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
