package com.pasifcode.muniautor.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.muniautor.domain.entity.Catalog;
import com.pasifcode.muniautor.domain.entity.Specification;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CatalogDto implements Serializable{

        @Serial
        private static final long serialVersionUID = 1L;

        private Long id;
        private String title;
        private String description;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDateTime createdDate;
        private Long userId;


        public CatalogDto() {
        }

        public CatalogDto(Catalog entity) {
            id = entity.getId();
            title = entity.getTitle();
            description = entity.getDescription();
            createdDate = entity.getCreatedDate();
            userId  = entity.getUser().getId();
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public LocalDateTime getCreatedDate() {
            return createdDate;
        }

        public Long getUserId() {
            return userId;
        }
    }


