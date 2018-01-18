package com.jones.panorama.controller;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.User;
import com.jones.panorama.service.UserService;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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


}
