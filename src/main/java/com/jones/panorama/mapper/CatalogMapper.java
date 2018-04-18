package com.jones.panorama.mapper;

import com.jones.panorama.model.Catalog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogMapper {
    List<Catalog> findAll();
}

