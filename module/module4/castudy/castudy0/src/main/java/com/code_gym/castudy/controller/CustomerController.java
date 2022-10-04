package com.code_gym.castudy.controller;

import com.code_gym.castudy.model.customer.Customer;
import com.code_gym.castudy.service.ICustomerService;
import com.code_gym.castudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/customer")
    public String customerList(Model model, @PageableDefault(size = 3) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        model.addAttribute("customerList", this.iCustomerService.findAllSearchAndPaging(keyWordValue, pageable));
        model.addAttribute("keyWordValue");
        return ("/customer/list");
    }

    @GetMapping("/customer/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("customers", new Customer());
        model.addAttribute("showCustomerType", this.iCustomerTypeService.findAll());
        return ("/customer/create");
    }

    @PostMapping("/create/save")

    public String create(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes, Model model) {

           this.iCustomerService.save(customer);


        redirectAttributes.addFlashAttribute("message", " add new successfully! ");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        this.iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "successfully delete");
        return "redirect:/customer";
    }


    @GetMapping("customer/showUpdate")
    public String showEditCustomerForm(@RequestParam Integer id, Model model) {

        model.addAttribute("customer",this.iCustomerService.getId(id));
        model.addAttribute("showCustomerType", this.iCustomerTypeService.findAll());

        return "/customer/edit";
    }


    @PostMapping("/update/customer")
    public String updateSong(Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");

        return "redirect:/customer";
    }
    @ExceptionHandler
    public String error(Exception e){
        return "error";
    }
}
