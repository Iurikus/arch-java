package com.yuri.archjava.controller;

import com.yuri.archjava.dto.AdminListItemDto;
import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import com.yuri.archjava.utils.JsonJTableResponse;
import com.yuri.archjava.utils.UsersJsonJTableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yuri on 22.03.2015.
 */

@Controller
public class AdminListController {

    @Autowired
    UserService userService;

   /* @RequestMapping(value = "/admin/list", method = RequestMethod.POST)
    @ResponseBody
    public UsersJsonJTableResponse getList(@RequestParam int jtStartIndex, @RequestParam int jtPageSize) {
        UsersJsonJTableResponse response = null;
        List<AdminListItemDto> userList = null;

        int listCount = (int) userService.getCount();

//        userList = userService.findAll(jtPageSize, jtPageSize).getContent();
        response = new UsersJsonJTableResponse("OK", userList, listCount);


        return response;
    }*/


    @RequestMapping(value = "/admin/listall", method = RequestMethod.GET)
    @ResponseBody
    public UsersJsonJTableResponse getList(@RequestParam(required = false, defaultValue = "0") int jtStartIndex, @RequestParam(required = false, defaultValue = "100") int jtPageSize) {
        UsersJsonJTableResponse response = null;
        List<AdminListItemDto> userList;

        int listCount = (int) userService.getCount();

//        userList = userService.findAll(0,100).getContent();
        userList = userService.getUserRecords(0, 100);
        response = new UsersJsonJTableResponse("OK", userList, listCount);

        return response;
    }

}
