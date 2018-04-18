package com.jones.panorama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/order"})
public class OrderController extends BaseController {
    @RequestMapping(value = {"/cart"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String cart() {
        return "order/cart";
    }

    @RequestMapping(value = {"/pay"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String pay() {
        return "order/pay";

    }
}
