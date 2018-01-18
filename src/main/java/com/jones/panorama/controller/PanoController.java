package com.jones.panorama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by jones on 18-1-16.
 */
@Controller
@RequestMapping( "/pano" )
public class PanoController extends BaseController{

    @RequestMapping(value = "/house", method = RequestMethod.GET)
    public String house(){
        return "pano/house";
    }
}
