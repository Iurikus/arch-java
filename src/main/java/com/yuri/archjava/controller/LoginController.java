package com.yuri.archjava.controller;

import com.yuri.archjava.model.SessionUser;
import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yuri on 18.04.2015.
 */
@Controller
@RequestMapping(value = "/login")
@SessionAttributes("sessionUser")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String initLogin(HttpServletRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);

        System.out.println("1=============================");
        System.out.println(request.getSession().getAttribute("sessionUser"));
        System.out.println("2=============================");

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submitLogin(@Validated User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            List<User> usersResult = userService.findByEmail(user.getEmail());
            if (usersResult.size() == 1) {
                User resultUser = usersResult.get(0);
                if(resultUser.getPassword().equals(user.getPassword())) {
                    ModelAndView modelAndView = new ModelAndView();
                    modelAndView.addObject(new SessionUser(resultUser.getId(), resultUser.isAdmin()));
                    if (resultUser.isAdmin()) {
                        modelAndView.setViewName("redirect:/admin.html");
                    } else {
                        modelAndView.setViewName("redirect:/balance.html");
                    }
                    return modelAndView;
                } else {
                    bindingResult.rejectValue("email", "login.messageWrongCredentials");
                }
            } else {
                bindingResult.rejectValue("email", "login.messageWrongCredentials");
            }
        }
        return new ModelAndView("login");
    }
}
