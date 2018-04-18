package com.jones.panorama.service;

import com.jones.panorama.model.*;
import com.jones.panorama.repository.HotspotRepository;
import com.jones.panorama.repository.HsScRepository;
import com.jones.panorama.repository.ScScRepository;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ScScService {

    @Autowired
    private ScScRepository scScRepository;

    @Autowired
    private HotspotRepository hotspotRepository;

    public Page<HsSc> findByPage(Query<HsSc> query) {
        return scScRepository.findByPage(query);
    }

    public Page<Hotspot> findHotspotByPage(Query<ScSc> query) {
        return scScRepository.findInnerHotspotByPage(query);
    }

    public List<Hotspot> findInnerHotspotList(Query<ScSc> query) {
        return scScRepository.findInnerHotspotList(query);
    }

    public GeneralResponse saveScSc(ScSc scSc) {
        GeneralResponse resp = new GeneralResponse(false, "添加失败，请重试！");
        resp = new GeneralResponse(true, "");
        scScRepository.save(scSc);
        return resp;
    }

    public GeneralResponse addInnerHotspot(Hotspot hotspot) {
        GeneralResponse resp = new GeneralResponse(false, "添加失败，请重试！");
        resp = new GeneralResponse(true, "");
        if (StringUtils.isEmpty(hotspot.getCode())) {
            hotspot.setCode(System.currentTimeMillis() + "");
        }
        hotspotRepository.save(hotspot);
        ScSc scSc = new ScSc();
        scSc.setAth(hotspot.getAth());
        scSc.setAtv(hotspot.getAtv());
        scSc.setHotspotCode(hotspot.getCode());
        scSc.setpHotspotCode(hotspot.getpHotspotCode());
        scScRepository.save(scSc);
        return resp;
    }

    public ScSc findOne(Integer id) {
        return scScRepository.findOne(id);
    }

    public void delete(Integer hsScId) {
        scScRepository.delete(hsScId);
    }
}

