package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.Scene;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SceneMapper {
    List<Scene> findList(Query paramQuery);

    List<Scene> findAll();

    Integer findCount(Query paramQuery);

    List<Scene> findByTitle(String paramString);

    void update(Scene paramScene);
}

