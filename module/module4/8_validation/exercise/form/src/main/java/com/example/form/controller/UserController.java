package com.example.form.controller;

import com.example.form.dto.UserDto;
import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/")
    public String formUser(Model model){
        model.addAttribute("userList",this.iUserService.userList());
        return "/list";
    }
    @GetMapping("/user/showCreate")
    public String showCreat(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/create";
    }

    @PostMapping("/create/save")
    public String save(@ModelAttribute ("userDto")@Valid UserDto userDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        }else {
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            this.iUserService.save(user);
            redirectAttributes.addFlashAttribute("message","successfully!");
            return "redirect:/";
    }
}
}
