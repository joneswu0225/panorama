package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.User;
//import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserMapper {
    List<User> findAll();
    List<User> findUsers(Query query);
    Integer findUserCount(Query query);
    User findUser(User user);
}
