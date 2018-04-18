package com.jones.panorama.mapper;

import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsSc;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.ScSc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScScMapper {
    List<ScSc> findList(Query paramQuery);

    List<Hotspot> findInnerHotspotList(Query paramQuery);

    Integer findCount(Query paramQuery);

    ScSc findOne(Integer paramInteger);

    void insert(ScSc paramHsSc);

    void update(ScSc paramHsSc);

    void delete(Integer paramInteger);
}

