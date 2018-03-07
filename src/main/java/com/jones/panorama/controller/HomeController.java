package com.jones.panorama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by jones on 18-1-16.
 */
@Controller
@RequestMapping( "/" )
public class HomeController extends BaseController{

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public String sample(){
        return "sample";
    }

    @RequestMapping(value = "/ws", method = RequestMethod.GET)
    public String socket(){
        return "socket";
    }
}
