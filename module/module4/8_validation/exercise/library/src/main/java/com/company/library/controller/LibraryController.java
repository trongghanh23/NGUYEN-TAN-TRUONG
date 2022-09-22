package com.company.library.controller;

import com.company.library.model.Book;
import com.company.library.model.Library;
import com.company.library.service.IBookService;
import com.company.library.service.ILibraryService;
import com.company.library.service.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @Controller
    @RequestMapping("/library")
    public class    LibraryController {

        @Autowired
        private ILibraryService iLibraryService;

        @Autowired
        private IBookService iBookService;

        @Autowired
        private ITrafficService iTrafficService;

        @GetMapping("")
        public String goHome(Model model) {
            model.addAttribute("library", this.iLibraryService.findAll());
            int view = this.iTrafficService.getById();
            model.addAttribute("view", view);
            return "library";
        }

        @GetMapping("/create")
        public String goCreate(Model model) {
            model.addAttribute("library", new Library());
            return "create-book";
        }

        @PostMapping("/create")
        public String create(@ModelAttribute("library") Library library) {
            this.iLibraryService.save(library);
            return "redirect:/library";
        }

        @GetMapping("/edit")
        public String editBlog(@PathVariable Integer id , Model model){
            model.addAttribute("blog",iBookService.(id));
            return "edit";
        }
        @PostMapping("/edit")
        public String updateBlog(Blogger blogger){
            this.iBlogService.save(blogger);
            return "redirect:/bloggers";
        }

        @ExceptionHandler(value = Exception.class)
        public String goError() {
            return "error";
        }
    }

