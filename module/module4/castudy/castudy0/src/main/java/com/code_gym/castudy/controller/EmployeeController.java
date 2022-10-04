package com.code_gym.castudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @GetMapping("/employee")
    public String listEmployee(){
        return "employee/list";
    }
}
