package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.Thumbup;
import org.springframework.stereotype.Repository;

@Repository
public interface ThumbupMapper {
    Integer findCount(Query paramQuery);

    void insert(Thumbup paramThumbup);

    void delete(Thumbup paramThumbup);
}

