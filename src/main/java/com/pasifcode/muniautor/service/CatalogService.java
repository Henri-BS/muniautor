package com.pasifcode.muniautor.service;

import com.pasifcode.muniautor.domain.dto.CatalogDto;

public interface CatalogService {

    CatalogDto findById(Long id);

    CatalogDto saveCatalog(CatalogDto dto);

    CatalogDto updateCatalog(CatalogDto dto);
}
