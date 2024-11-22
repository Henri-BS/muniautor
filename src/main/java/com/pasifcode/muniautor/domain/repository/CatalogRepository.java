package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
