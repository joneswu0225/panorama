package com.jones.panorama.mapper;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Thumbup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThumbupMapper {
    Integer findCount(Query query);

    void insert(Thumbup thumbup);

    void delete(Integer thumbupId);
}
