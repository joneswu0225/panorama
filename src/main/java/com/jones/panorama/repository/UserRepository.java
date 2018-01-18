package com.jones.panorama.repository;

import com.jones.panorama.mapper.UserMapper;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.User;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jones on 18-1-17.
 */
//@Repository
public class UserRepository {
   /* @Autowired
    private UserMapper userMapper;

    public Page<User> findUserByPage(Query<User> query){
        Integer count = userMapper.findUserCount(query);
        return new Page<>(query, count, userMapper.findUsers(query));
    }

    public User findUser(User user){
        return userMapper.findUser(user);
    }

    public List<User> findAll(){
        return  userMapper.findAll();
    }*/
}
