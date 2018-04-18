package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract interface UserMapper {
    public abstract List<User> findAll();

    public abstract List<User> findList(Query paramQuery);

    public abstract Integer findCount(Query paramQuery);

    public abstract User findOne(User paramUser);

    public abstract void insert(User paramUser);

    public abstract void update(User paramUser);
}
