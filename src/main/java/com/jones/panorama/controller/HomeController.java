package com.jones.panorama.controller;

import com.jones.panorama.model.GeneralResponse;
import com.jones.panorama.util.RandomString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/"})
public class HomeController extends BaseController {
    @RequestMapping(value = {"/login"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/sample"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String sample() {
        return "test/sample";
    }

    @RequestMapping(value = {"/ws"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String socket() {
        return "test/socket";
    }

    @ResponseBody
    @RequestMapping(value = {"/getCode"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    GeneralResponse getCode() {
        return new GeneralResponse(true, RandomString.generate(5));
    }
}
