package com.code_gym.blog.controller;

import com.code_gym.blog.model.Blog;
import com.code_gym.blog.repository.ICategoryRepository;
import com.code_gym.blog.service.IBlogService;
import com.code_gym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService  iCategoryService;

    @GetMapping("/blog")
    public String customerList(Model model, @PageableDefault(size = 3) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        model.addAttribute("blogList", this.iBlogService.searchByTitle(keyWordValue, pageable));
        model.addAttribute("keyWordValue");
        return ("/index");
    }



}
