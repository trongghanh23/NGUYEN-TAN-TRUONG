package com.company.library.controller;

public class LibraryController {
    import com.codegym.manage_library.model.Book;
import com.codegym.manage_library.model.Library;
import com.codegym.manage_library.service.IBookService;
import com.codegym.manage_library.service.ILibraryService;
import com.codegym.manage_library.service.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation .*;

import java.util.List;
import java.util.Optional;


    @Controller
    @RequestMapping("/library")
    public class LibraryController {

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

        @GetMapping("/show-detail")
        public String showDetail(@RequestParam Optional<Integer> id, Model model) {
            if (id.isPresent()) {
                this.iLibraryService.borrowBook(id.get());
            }
            List<Book> bookList = this.iBookService.findAll();
            model.addAttribute("bookList", bookList);
            return "list-borrow";
        }

        @GetMapping("/borrow")
        public String borrowBook(@RequestParam Integer id) {
            this.iLibraryService.setQuantity(id);
            this.iBookService.setStatus(id);
            return "redirect:/library/show-details";
        }

        @GetMapping("/return")
        public String returnBook(@RequestParam Integer bookCode) throws Exception {
            this.iBookService.returnBook(bookCode);
            return "redirect:/library";
        }

        @ExceptionHandler(value = Exception.class)
        public String goError() {
            return "error";
        }
    }
}
