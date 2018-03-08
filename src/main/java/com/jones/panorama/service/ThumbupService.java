package com.jones.panorama.service;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Thumbup;
import com.jones.panorama.repository.CommentRepository;
import com.jones.panorama.repository.HotspotRepository;
import com.jones.panorama.repository.ThumbupRepository;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jones on 18-1-16.
 */
@Service
public class ThumbupService {
    @Autowired
    private ThumbupRepository thumbupRepository;

    public void saveThumbup(Thumbup thumbup){
        thumbupRepository.save(thumbup);
    }

    public void deleteThumbup(Thumbup thumbup){
        thumbupRepository.delete(thumbup);
    }

    public Integer findCount(Query<Thumbup> query){
        return thumbupRepository.findCount(query);
    }
}
