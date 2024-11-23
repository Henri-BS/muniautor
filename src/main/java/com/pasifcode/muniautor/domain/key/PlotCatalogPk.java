package com.pasifcode.muniautor.domain.key;

import com.pasifcode.muniautor.domain.entity.Catalog;
import com.pasifcode.muniautor.domain.entity.Plot;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlotCatalogPk implements Serializable {

    @Serial
    private static final long serialVersionUID = 1l;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlotCatalogPk that = (PlotCatalogPk) o;
        return Objects.equals(plot, that.plot) && Objects.equals(catalog, that.catalog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plot, catalog);
    }
}
