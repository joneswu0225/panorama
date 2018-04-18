package com.jones.panorama.repository;

import com.jones.panorama.mapper.CommentMapper;
import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    private CommentMapper commentMapper;

    public Page<Comment> findByPage(Query<Comment> query) {
        Integer count = findCount(query);
        return new Page(query, count, findList(query));
    }

    public List<Comment> findList(Query<Comment> query) {
        return this.commentMapper.findList(query);
    }

    public Integer findCount(Query<Comment> query) {
        return this.commentMapper.findCount(query);
    }

    public void save(Comment comment) {
        if (comment.getCommentId() == null)
            this.commentMapper.insert(comment);
        else
            this.commentMapper.update(comment);
    }
}

