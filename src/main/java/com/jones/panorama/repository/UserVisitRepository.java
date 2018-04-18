package com.jones.panorama.repository;

import com.jones.panorama.mapper.UserVisitMapper;
import com.jones.panorama.model.UserVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserVisitRepository {

    @Autowired
    private UserVisitMapper userVisitMapper;

    public void insert(UserVisit userVisit) {
        this.userVisitMapper.insert(userVisit);
    }
}

