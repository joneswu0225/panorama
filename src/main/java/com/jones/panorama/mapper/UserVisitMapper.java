package com.jones.panorama.mapper;

import com.jones.panorama.model.UserVisit;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface UserVisitMapper {
    public abstract void insert(UserVisit paramUserVisit);
}
