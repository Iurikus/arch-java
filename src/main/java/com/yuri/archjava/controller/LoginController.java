package com.yuri.archjava.controller;

import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yuri on 18.04.2015.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String initLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitLogin(@Validated User user, BindingResult result) {
        if (!result.hasErrors()) {

            List<User> usersResult = userService.findByEmail(user.getEmail());
            if (usersResult.size() == 1 && usersResult.get(0).getPassword().equals(user.getPassword())) {
                return "redirect:/admin.html";
            } else {
                result.rejectValue("email", "login.messageWrongCredentials");
            }
        }
        return "login";
    }
}
