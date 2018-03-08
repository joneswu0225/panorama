package com.jones.panorama.repository;

import com.jones.panorama.mapper.CommentMapper;
import com.jones.panorama.mapper.HotspotMapper;
import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.Query;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jones on 18-1-17.
 */
@Repository
public class HotspotRepository {
    @Autowired
    private HotspotMapper hotspotMapper;

    public void save(Hotspot hotspot){
        if(hotspot.getHotspotId() == null){
            hotspotMapper.insert(hotspot);
        } else {
            hotspotMapper.update(hotspot);
        }
    }
}
