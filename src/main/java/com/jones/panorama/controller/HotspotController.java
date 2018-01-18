package com.jones.panorama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by jones on 18-1-16.
 */
@Controller
@RequestMapping( "/pano/hotspot" )
public class HotspotController extends BaseController{

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(){
        return "login";
    }
}
