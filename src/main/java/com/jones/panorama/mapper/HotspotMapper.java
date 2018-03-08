package com.jones.panorama.mapper;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotspotMapper {
    void insert(Hotspot hotspot);
    void update(Hotspot hotspot);
}
