package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();

    List<User> findList(Query paramQuery);

    Integer findCount(Query paramQuery);

    User findOne(User paramUser);

    void insert(User paramUser);

    void update(User paramUser);
}
