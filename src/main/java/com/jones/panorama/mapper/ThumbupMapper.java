package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.Thumbup;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface ThumbupMapper {
    public abstract Integer findCount(Query paramQuery);

    public abstract void insert(Thumbup paramThumbup);

    public abstract void delete(Thumbup paramThumbup);
}

