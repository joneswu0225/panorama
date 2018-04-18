package com.jones.panorama.repository;

import com.jones.panorama.mapper.CatalogMapper;
import com.jones.panorama.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogRepository {

    @Autowired
    private CatalogMapper catalogMapper;

    public List<Catalog> findAll() {
        return this.catalogMapper.findAll();
    }
}

