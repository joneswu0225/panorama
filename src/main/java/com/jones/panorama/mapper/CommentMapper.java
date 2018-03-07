package com.jones.panorama.mapper;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    List<Comment> findList(Query query);
    Integer findCount(Query query);
    void insert(Comment comment);
    void update(Comment comment);
}
