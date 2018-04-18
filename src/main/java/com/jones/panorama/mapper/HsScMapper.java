package com.jones.panorama.mapper;

import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsSc;
import com.jones.panorama.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract interface HsScMapper {
    public abstract List<HsSc> findList(Query paramQuery);

    public abstract List<Hotspot> findHotspotList(Query paramQuery);

    public abstract Integer findCount(Query paramQuery);

    public abstract HsSc findOne(Integer paramInteger);

    public abstract void insert(HsSc paramHsSc);

    public abstract void update(HsSc paramHsSc);

    public abstract void delete(Integer paramInteger);
}

