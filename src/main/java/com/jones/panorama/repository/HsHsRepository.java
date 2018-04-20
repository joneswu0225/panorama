package com.jones.panorama.repository;

import com.jones.panorama.mapper.HsHsMapper;
import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsHs;
import com.jones.panorama.model.HsSc;
import com.jones.panorama.model.Query;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HsHsRepository {

    @Autowired
    private HsHsMapper hsHsMapper;

    public Page<HsHs> findByPage(Query query) {
        Integer count = findCount(query);
        return new Page(query, count, findList(query));
    }

    public Page<Hotspot> findInnerHotspotByPage(Query query) {
        Integer count = findCount(query);
        return new Page(query, count, findInnerHotspotList(query));
    }

    public List<HsHs> findList(Query query) {
        return this.hsHsMapper.findList(query);
    }

    public List<Hotspot> findInnerHotspotList(Query query) {
        return this.hsHsMapper.findInnerHotspotList(query);
    }

    public List<Hotspot> findAll() {
        return this.hsHsMapper.findInnerHotspotList(new Query());
    }

    public Integer findCount(Query query) {
        return this.hsHsMapper.findCount(query);
    }

    public HsHs findOne(Integer id) {
        return this.hsHsMapper.findOne(id);
    }

    public void save(HsHs hsHs) {
        if (hsHs.getHsHsId() == null)
            this.hsHsMapper.insert(hsHs);
        else
            this.hsHsMapper.update(hsHs);
    }

    public void delete(Integer hsScId) {
        this.hsHsMapper.delete(hsScId);
    }
}

