package com.yuri.archjava.controller;

import com.yuri.archjava.model.Balance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yuri on 18.04.2015.
 */
@Controller
@RequestMapping(value = "/balance")
public class BalanceController {
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        Balance balance = new Balance();
        balance.setAmount(178);
        model.addAttribute("balance", balance);
        return "balance";
    }
}
