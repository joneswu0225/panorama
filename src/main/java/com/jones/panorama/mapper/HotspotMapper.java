package com.jones.panorama.mapper;

import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract interface HotspotMapper {
    public abstract List<Hotspot> findList(Query paramQuery);

    public abstract List<Hotspot> findAll();

    public abstract Hotspot findOne(Integer paramInteger);

    public abstract Integer findCount(Query paramQuery);

    public abstract List<Hotspot> findByCode(String paramString);

    public abstract void insert(Hotspot paramHotspot);

    public abstract void update(Hotspot paramHotspot);

    public abstract void delete(Integer paramInteger);
}

