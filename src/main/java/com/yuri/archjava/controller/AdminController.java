package com.yuri.archjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yuri on 22.03.2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {



        return "admin";
    }
}
