package com.pasifcode.muniautor.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.muniautor.domain.entity.PlotCatalog;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class PlotCatalogDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;
    private Long userId;
    private Long plotId;
    private String plotTitle;
    private Long catalogId;

    public PlotCatalogDto() {
    }

    public PlotCatalogDto(PlotCatalog entity) {
        createdDate = entity.getCreatedDate();
        userId = entity.getUser().getId();
        plotId = entity.getPlot().getId();
        plotTitle = entity.getPlot().getTitle();
        catalogId = entity.getCatalog().getId();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPlotId() {
        return plotId;
    }

    public String getPlotTitle() {
        return plotTitle;
    }

    public Long getCatalogId() {
        return catalogId;
    }
}
