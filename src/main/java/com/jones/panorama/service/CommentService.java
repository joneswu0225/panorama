package com.jones.panorama.service;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Thumbup;
import com.jones.panorama.repository.CommentRepository;
import com.jones.panorama.repository.HotspotRepository;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private HotspotRepository hotspotRepository;

    public Page<Comment> findByPage(Query<Comment> query) {
        return this.commentRepository.findByPage(query);
    }

    public void saveComment(Comment comment) {
        this.hotspotRepository.save(comment.getHotspot());
        this.commentRepository.save(comment);
    }

    public void saveThumbup(Thumbup thumbup) {
    }
}

