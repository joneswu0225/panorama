package com.jones.panorama.controller;

import com.jones.panorama.model.GeneralResponse;
import com.jones.panorama.model.Hotspot;
import com.jones.panorama.model.HsSc;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Scene;
import com.jones.panorama.service.HsScService;
import com.jones.panorama.service.SceneService;
import com.jones.panorama.util.Page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/pano"})
public class PanoController extends BaseController {

    @Autowired
    private HsScService hsScService;

    @Autowired
    private SceneService sceneService;

    @RequestMapping(value = {"/house"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String house() {
        return "pano/house";
    }

    @RequestMapping(value = {"/mari"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String mari() {
        return "pano/mari";
    }

    @ResponseBody
    @RequestMapping(value = {"/hotspotList"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public Page<Hotspot> hotspotList(@RequestParam(value = "sceneCode", required = false) String sceneCode, @RequestParam(value = "size", required = false, defaultValue = "20") int size, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        HsSc hsSc = new HsSc();
        hsSc.setSceneCode(sceneCode);
        Page list = this.hsScService.findHotspotByPage(getQuery(page, size, hsSc));
        return list;
    }

    @ResponseBody
    @RequestMapping(value = {"/hotspots"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public List<Hotspot> allhotspots() {
        return this.hsScService.findHotspotList(new Query());
    }

    @ResponseBody
    @RequestMapping(value = {"/scenes"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public List<Scene> allScene() {
        return this.sceneService.findList(new Query());

    }

    @ResponseBody
    @RequestMapping(value = {"/addHotspot"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    public GeneralResponse addHotspot(Hotspot hotspot) {
        GeneralResponse resp = this.hsScService.addHotspot(hotspot);
        return resp;
    }
}

