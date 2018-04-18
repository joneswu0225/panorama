package com.jones.panorama.mapper;

import com.jones.panorama.model.UserVisit;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVisitMapper {
    void insert(UserVisit paramUserVisit);
}
