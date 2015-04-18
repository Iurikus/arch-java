package com.yuri.archjava.controller;

import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yuri on 13.04.2015.
 */
@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String initRegistration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitRegistration(@Validated User user, BindingResult result) {
        System.out.println(user);
        System.out.println("===============");
        if (!result.hasErrors()) {
            if (user.getPassword().equals(user.getPassword2())) {
                if (userService.save(user)) {
                    return "redirect:/balance.html";
                } else {
                    result.rejectValue("email", "registration.user_duplicate");
                }
            } else {
                System.out.println("reject");
                result.rejectValue("password", "registration.password_not_duplicate");
            }
        } else  {
            for (ObjectError objectError : result.getAllErrors()) {
                System.out.println(objectError.toString());
            }
        }
        return "registration";
    }
}
