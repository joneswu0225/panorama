package com.jones.panorama.repository;

import com.jones.panorama.mapper.HsScMapper;
import com.jones.panorama.mapper.ScScMapper;
import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsSc;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.ScSc;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScScRepository {

    @Autowired
    private ScScMapper scScMapper;

    public Page<HsSc> findByPage(Query query) {
        Integer count = findCount(query);
        return new Page(query, count, findList(query));
    }

    public Page<Hotspot> findInnerHotspotByPage(Query query) {
        Integer count = findCount(query);
        return new Page(query, count, findInnerHotspotList(query));
    }

    public List<ScSc> findList(Query query) {
        return this.scScMapper.findList(query);
    }

    public List<Hotspot> findInnerHotspotList(Query query) {
        return this.scScMapper.findInnerHotspotList(query);
    }

    public Integer findCount(Query query) {
        return this.scScMapper.findCount(query);
    }

    public ScSc findOne(Integer id) {
        return this.scScMapper.findOne(id);
    }

    public void save(ScSc scSc) {
        if (scSc.getHsScId() == null)
            this.scScMapper.insert(scSc);
        else
            this.scScMapper.update(scSc);
    }

    public void delete(Integer hsScId) {
        this.scScMapper.delete(hsScId);
    }
}

