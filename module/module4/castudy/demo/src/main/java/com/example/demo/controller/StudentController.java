package com.example.demo.controller;

import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @GetMapping("")
//    public String displayBlog(Model model, @PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> search){
//        String searchName = search.orElse("");
//        model.addAttribute("searchName",searchName);
//        model.addAttribute("blogList", this.iBlogService.getAllBlog(searchName,pageable));
//        return "list";
//    }
}
