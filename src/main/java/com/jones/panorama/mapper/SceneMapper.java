package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.Scene;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract interface SceneMapper {
    public abstract List<Scene> findList(Query paramQuery);

    public abstract List<Scene> findAll();

    public abstract Integer findCount(Query paramQuery);

    public abstract List<Scene> findByTitle(String paramString);

    public abstract void update(Scene paramScene);
}

