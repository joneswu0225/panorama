package com.jones.panorama.repository;

import com.jones.panorama.mapper.HotspotMapper;
import com.jones.panorama.mapper.ThumbupMapper;
import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Thumbup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jones on 18-1-17.
 */
@Repository
public class ThumbupRepository {
    @Autowired
    private ThumbupMapper thumbupMapper;

    public void save(Thumbup thumbup){
        thumbupMapper.insert(thumbup);
    }

    public void delete(Integer thumbupId){
        thumbupMapper.delete(thumbupId);
    }

    public Integer findCount(Query<Thumbup> query){
        return thumbupMapper.findCount(query);
    }
}
