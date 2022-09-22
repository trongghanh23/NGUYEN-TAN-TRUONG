package com.code_gym.book.controller;

import com.code_gym.book.exception.QualityZezoException;
import com.code_gym.book.model.Book;
import com.code_gym.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/book")
    public String bookList(Model model, @PageableDefault(size = 3) Pageable pageable) {

        model.addAttribute("bookList", this.iBookService.findAll(pageable));

        return ("/list");
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable int id, Model model) throws QualityZezoException {
        Book book = iBookService.getId(id);

        if (book.getCount() == 0) {
            throw new QualityZezoException();
        } else {
            model.addAttribute("book", book);
            return "borrow";
        }

    }

    @PostMapping("/borrow")
    public String showBorrow(@ModelAttribute Book book, RedirectAttributes redirect) {
        book.setCount(book.getCount() - 1);
        iBookService.save(book);
        redirect.addFlashAttribute("message", "Borrow book successfully! ");
        return "redirect:/book";
    }

    @GetMapping("/pay/{id}")
    public String pay(@PathVariable int id, Model model) {
        Book book = iBookService.getId(id);
        model.addAttribute("book", book);
        return "pay";

    }

    @PostMapping("/pay")
    public String showPay(@ModelAttribute Book book, RedirectAttributes redirect) {
        book.setCount(book.getCount() + 1);
        iBookService.save(book);
        redirect.addFlashAttribute("message", "Pay book successfully! ");
        return "redirect:/book";
    }

    @ExceptionHandler(QualityZezoException.class)
    public String goError() {
        return "error";
    }

}
