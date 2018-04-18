package com.jones.panorama.repository;

import com.jones.panorama.mapper.SceneMapper;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Scene;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SceneRepository {

    @Autowired
    private SceneMapper sceneMapper;

    public Page<Scene> findByPage(Query query) {
        Integer count = findCount(query);
        return new Page(query, count, findList(query));
    }

    public List<Scene> findList(Query query) {
        return this.sceneMapper.findList(query);
    }

    public List<Scene> findAll() {
        return this.sceneMapper.findAll();
    }

    public Integer findCount(Query query) {
        return this.sceneMapper.findCount(query);
    }

    public boolean existsTitle(String title) {
        List list = this.sceneMapper.findByTitle(title);
        return list.size() > 0;
    }

    public void save(Scene scene) {
        this.sceneMapper.update(scene);
    }
}

