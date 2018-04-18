package com.jones.panorama.controller;

import com.jones.panorama.model.*;
import com.jones.panorama.service.HsScService;
import com.jones.panorama.service.QuestionService;
import com.jones.panorama.service.ScScService;
import com.jones.panorama.service.SceneService;
import com.jones.panorama.util.Page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/pano"})
public class PanoController extends BaseController {

    @Autowired
    private HsScService hsScService;
    @Autowired
    private ScScService scScService;

    @Autowired
    private SceneService sceneService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = {"/house"}, method = {RequestMethod.GET})
    public String house() {
        return "pano/house";
    }

    @RequestMapping(value = {"/mari"}, method = {RequestMethod.GET})
    public String mari() {
        return "pano/mari";
    }

    @ResponseBody
    @RequestMapping(value = {"/hotspotList"}, method = {RequestMethod.GET})
    public Page<Hotspot> hotspotList(@RequestParam(value = "sceneCode", required = false) String sceneCode, @RequestParam(value = "size", required = false, defaultValue = "20") int size, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        HsSc hsSc = new HsSc();
        hsSc.setSceneCode(sceneCode);
        Page list = hsScService.findHotspotByPage(getQuery(page, size, hsSc));
        return list;
    }

    @ResponseBody
    @RequestMapping(value = {"/hotspots"}, method = {RequestMethod.GET})
    public List<Hotspot> allhotspots() {
        return this.hsScService.findHotspotList(new Query());
    }

    @ResponseBody
    @RequestMapping(value = {"/innerHotspots"}, method = {RequestMethod.GET})
    public List<Hotspot> allinnerHotspots() {
        return this.scScService.findInnerHotspotList(new Query());
    }

    @ResponseBody
    @RequestMapping(value = {"/scenes"}, method = {RequestMethod.GET})
    public List<Scene> allScene() {
        return sceneService.findList(new Query());
    }
    @ResponseBody
    @RequestMapping(value = {"/questions"}, method = {RequestMethod.GET})
    public List<Question> allQuestion() {
        return questionService.findList(new Query());
    }

    @ResponseBody
    @RequestMapping(value = {"/addHotspot"}, method = {RequestMethod.POST})
    public GeneralResponse addHotspot(Hotspot hotspot) {
        GeneralResponse resp = new GeneralResponse(false, "");
        if(StringUtils.isEmpty(hotspot.getpHotspotCode())){
            resp = hsScService.addHotspot(hotspot);
        } else {
            resp = scScService.addInnerHotspot(hotspot);
        }
        return resp;
    }

    @ResponseBody
    @RequestMapping(value = {"/addQuestion"}, method = {RequestMethod.POST})
    public GeneralResponse addQuestion(Question question) {
        GeneralResponse resp = questionService.saveQuestion(question);
        return resp;
    }
}

