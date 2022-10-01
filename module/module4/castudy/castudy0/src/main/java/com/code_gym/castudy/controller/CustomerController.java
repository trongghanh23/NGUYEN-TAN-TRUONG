package com.code_gym.castudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("/customer")
    public String listCustomer(Model model){
        return "/customer/list";
    }

}
