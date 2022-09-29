package com.example.demo.controller;

import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String studentList(Model model, @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        model.addAttribute("blogList",this.iBlogService.findAllSearchAndPaging(keyWordValue));
        return "/list";
    }

//
//    @GetMapping("/customer")
//    public String customerList(Model model, @PageableDefault(size = 3) Pageable pageable,
//                               @RequestParam Optional<String> keyword) {
//        String keyWordValue = keyword.orElse("");
//        model.addAttribute("customerList", this.iCustomerService.findAllSearchAndPaging(keyWordValue, pageable));
//        model.addAttribute("keyWordValue");
//        return ("/customer/list");
//    }

}
