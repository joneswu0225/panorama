package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();
    List<User> findList(Query query);
    Integer findCount(Query query);
    User findOne(User user);

    void insert(User user);
    void update(User user);
}
