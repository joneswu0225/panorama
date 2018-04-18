package com.jones.panorama.mapper;

import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsSc;
import com.jones.panorama.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HsScMapper {
    List<HsSc> findList(Query paramQuery);

    List<Hotspot> findHotspotList(Query paramQuery);

    Integer findCount(Query paramQuery);

    HsSc findOne(Integer paramInteger);

    void insert(HsSc paramHsSc);

    void update(HsSc paramHsSc);

    void delete(Integer paramInteger);
}

