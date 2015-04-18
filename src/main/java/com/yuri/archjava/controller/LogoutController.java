package com.yuri.archjava.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by yuri on 19.04.2015.
 */
@Component
@RequestMapping(value = "/logout")
public class LogoutController {
    @RequestMapping(method = RequestMethod.GET)
    String doRequest(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
