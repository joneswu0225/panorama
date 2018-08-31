package com.jones.panorama.service;

import com.jones.panorama.model.GeneralResponse;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Scene;
import com.jones.panorama.repository.SceneRepository;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneService {

    @Autowired
    private SceneRepository sceneRepository;

    public Page<Scene> findByPage(Query<Scene> query) {
        return sceneRepository.findByPage(query);
    }

    public List<Scene> findList(Query<Scene> query) {
        return sceneRepository.findList(query);
    }

    public GeneralResponse saveScene(Scene scene) {
        GeneralResponse resp = new GeneralResponse(false, "添加失败，请重试！");
        if (scene.getSceneId() == null && sceneRepository.existsTitle(scene.getTitle())) {
            resp.setMsg("title 已存在！");
        } else {
            resp = new GeneralResponse(true, "");
            sceneRepository.save(scene);
        }
        return resp;
    }

    public List<Scene> findAll() {
        return sceneRepository.findAll();
    }
}

