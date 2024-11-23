package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.application.exceptions.ResourceNotFoundException;
import com.pasifcode.muniautor.domain.dto.CatalogDto;
import com.pasifcode.muniautor.domain.entity.Catalog;
import com.pasifcode.muniautor.domain.entity.User;
import com.pasifcode.muniautor.domain.repository.CatalogRepository;
import com.pasifcode.muniautor.domain.repository.UserRepository;
import com.pasifcode.muniautor.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public CatalogDto findById(Long id) {
        Catalog find = catalogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new CatalogDto(find);
    }

    @Override
    @Transactional
    public CatalogDto saveCatalog(CatalogDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(dto.getUserId()));

        Catalog add = new Catalog();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setUser(user);

        return new CatalogDto(catalogRepository.saveAndFlush(add));
    }

    @Override
    @Transactional
    public CatalogDto updateCatalog(CatalogDto dto) {
        Catalog edit = catalogRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(dto.getId()));

        edit.setId(edit.getId());
        edit.setTitle(dto.getTitle());
        edit.setDescription(dto.getDescription());

        return new CatalogDto(catalogRepository.save(edit));
    }
}
