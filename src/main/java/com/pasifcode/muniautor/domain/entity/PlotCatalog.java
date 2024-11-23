package com.pasifcode.muniautor.domain.entity;


import com.pasifcode.muniautor.domain.key.PlotCatalogPk;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_plot_catalog")
public class PlotCatalog {

    @EmbeddedId
    private PlotCatalogPk id = new PlotCatalogPk();

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public PlotCatalog() {
    }

    public PlotCatalog(Plot plot, Catalog catalog) {
        id.setPlot(plot);
        id.setCatalog(catalog);
    }

    public Plot getPlot() {
        return id.getPlot();
    }

    public void setPlot(Plot plot) {
         id.setPlot(plot);
    }

    public Catalog getCatalog() {
        return id.getCatalog();
    }

    public void setCatalog(Catalog catalog) {
        id.setCatalog(catalog);
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
