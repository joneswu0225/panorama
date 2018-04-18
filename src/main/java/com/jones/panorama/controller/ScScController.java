package com.jones.panorama.controller;

import com.jones.panorama.model.*;
import com.jones.panorama.service.HotspotService;
import com.jones.panorama.service.HsScService;
import com.jones.panorama.service.ScScService;
import com.jones.panorama.service.SceneService;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/pano/scsc"})
public class ScScController extends BaseController {

    @Autowired
    private HotspotService hotspotService;
    @Autowired
    private SceneService sceneService;
    @Autowired
    private ScScService scScService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "pHotspotCode", required = false) String pHotspotCode,
                       @RequestParam(value = "hotspotCode", required = false) String hotspotCode,
                       @RequestParam(value = "size", required = false, defaultValue = "20") int size,
                       @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                       ModelMap map) {
        ScSc scSc = new ScSc();
        scSc.setpHotspotCode(pHotspotCode);
        scSc.setHotspotCode(hotspotCode);
        Page<HsSc> list = scScService.findByPage(getQuery(page, size, scSc));
        Map<String, String> hotspotMap = hotspotService.findAll().stream().collect(Collectors.toMap(Hotspot::getCode, Hotspot::getTitle));
        map.put("page", list);
        map.put("hotspotCode", hotspotCode);
        map.put("pHotspotCode", pHotspotCode);
        map.put("hotspotMap", hotspotMap);
        return "pano/scsc/list";
    }

    @ResponseBody
    @RequestMapping(value = {"/save"}, method = {RequestMethod.POST})
    GeneralResponse saveScsc(ScSc scSc) {
        return scScService.saveScSc(scSc);

    }

    @ResponseBody
    @RequestMapping(value = {"/delete"}, method = {RequestMethod.POST})
    GeneralResponse saveHotspot(@RequestParam("hsScId") Integer hsScId) {
        scScService.delete(hsScId);
        return new GeneralResponse(true, "success");
    }

    @ResponseBody
    @RequestMapping(value = {"/{scScId}"}, method = {RequestMethod.GET})
    ScSc findOne(@PathVariable("scScId") Integer scScId) {
        return scScService.findOne(scScId);
    }
}
