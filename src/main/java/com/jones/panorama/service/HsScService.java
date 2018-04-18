package com.jones.panorama.service;

import com.jones.panorama.model.GeneralResponse;
import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsSc;
import com.jones.panorama.model.Query;
import com.jones.panorama.repository.HotspotRepository;
import com.jones.panorama.repository.HsScRepository;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class HsScService {

    @Autowired
    private HsScRepository hsScRepository;

    @Autowired
    private HotspotRepository hotspotRepository;

    public Page<HsSc> findByPage(Query<HsSc> query) {
        return this.hsScRepository.findByPage(query);
    }

    public Page<Hotspot> findHotspotByPage(Query<HsSc> query) {
        return this.hsScRepository.findHotspotByPage(query);
    }

    public List<Hotspot> findHotspotList(Query<HsSc> query) {
        return this.hsScRepository.findHotspotList(query);
    }

    public GeneralResponse saveHsSc(HsSc hsSc) {
        GeneralResponse resp = new GeneralResponse(false, "添加失败，请重试！");
        resp = new GeneralResponse(true, "");
        this.hsScRepository.save(hsSc);
        return resp;
    }

    public GeneralResponse addHotspot(Hotspot hotspot) {
        GeneralResponse resp = new GeneralResponse(false, "添加失败，请重试！");
        resp = new GeneralResponse(true, "");
        if (StringUtils.isEmpty(hotspot.getCode())) {
            hotspot.setCode(System.currentTimeMillis() + "");
        }
        this.hotspotRepository.save(hotspot);
        HsSc hsSc = new HsSc();
        hsSc.setAth(hotspot.getAth());
        hsSc.setAtv(hotspot.getAtv());
        hsSc.setHotspotCode(hotspot.getCode());
        hsSc.setSceneCode(hotspot.getSceneCode());
        this.hsScRepository.save(hsSc);
        return resp;
    }

    public HsSc findOne(Integer id) {
        return this.hsScRepository.findOne(id);
    }

    public void delete(Integer hsScId) {
        this.hsScRepository.delete(hsScId);
    }
}

