package com.code_gym.blogs.controller;


import com.code_gym.blogs.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public String customerList(Model model) {
        model.addAttribute("blogList", this.iBlogService.findAll());

        return ("/list");
    }


}
