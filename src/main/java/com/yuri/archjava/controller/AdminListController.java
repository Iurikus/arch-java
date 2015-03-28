package com.yuri.archjava.controller;

import com.yuri.archjava.utils.JsonJTableResponce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuri on 22.03.2015.
 */
public class AdminListController {

    @RequestMapping(value = "/admin/list", method = RequestMethod.POST)
    @ResponseBody
    public String getList(@RequestParam int jtStartIndex, @RequestParam int jtPageSize) {
        JsonJTableResponce responce;


        return "";
    }

}
