package com.jones.panorama.service;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.Thumbup;
import com.jones.panorama.repository.ThumbupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThumbupService {

    @Autowired
    private ThumbupRepository thumbupRepository;

    public void saveThumbup(Thumbup thumbup) {
        this.thumbupRepository.save(thumbup);
    }

    public void deleteThumbup(Thumbup thumbup) {
        this.thumbupRepository.delete(thumbup);
    }

    public Integer findCount(Query<Thumbup> query) {
        return this.thumbupRepository.findCount(query);
    }
}

