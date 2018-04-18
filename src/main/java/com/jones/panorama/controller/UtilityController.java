package com.jones.panorama.controller;

import com.jones.panorama.repository.CatalogRepository;
import com.jones.panorama.repository.HotspotRepository;
import com.jones.panorama.repository.SceneRepository;
import com.jones.panorama.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/utils"})
public class UtilityController extends BaseController {

    @Autowired
    private StyleRepository styleRepository;

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private SceneRepository sceneRepository;

    @Autowired
    private HotspotRepository hotspotRepository;

    @RequestMapping(value = {"/selector"}, method = {RequestMethod.GET})
    public String list(@RequestParam(value = "type", required = false, defaultValue = "tag") String type, ModelMap map) {
        Iterable list = null;
        switch (type) {
            case "style":
                list = this.styleRepository.findAll();
                break;
            case "catalog":
                list = this.catalogRepository.findAll();
                break;
            case "scene":
                list = this.sceneRepository.findAll();
                break;
            case "hotspot":
                list = this.hotspotRepository.findAll();
        }

        map.put("type", type);
        map.put("list", list);
        return "common/searchbar";
    }
}
