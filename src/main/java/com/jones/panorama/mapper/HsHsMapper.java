package com.jones.panorama.mapper;

import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsHs;
import com.jones.panorama.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HsHsMapper {
    List<HsHs> findList(Query paramQuery);

    List<Hotspot> findInnerHotspotList(Query paramQuery);

    Integer findCount(Query paramQuery);

    HsHs findOne(Integer paramInteger);

    void insert(HsHs paramHsSc);

    void update(HsHs paramHsSc);

    void delete(Integer paramInteger);
}

