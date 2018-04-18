package com.jones.panorama.mapper;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract interface CommentMapper {
    public abstract List<Comment> findList(Query paramQuery);

    public abstract Integer findCount(Query paramQuery);

    public abstract void insert(Comment paramComment);

    public abstract void update(Comment paramComment);
}
