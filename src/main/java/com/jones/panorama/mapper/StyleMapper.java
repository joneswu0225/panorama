package com.jones.panorama.mapper;

import com.jones.panorama.model.Style;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleMapper {
    List<Style> findAll();
}

