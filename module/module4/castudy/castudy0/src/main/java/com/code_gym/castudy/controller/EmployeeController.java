package com.code_gym.castudy.controller;

import com.code_gym.castudy.service.IDivisionService;
import com.code_gym.castudy.service.IEducationDegreeService;
import com.code_gym.castudy.service.IEmployeeService;
import com.code_gym.castudy.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;
    @GetMapping("")
    public String employeeList(Model model, @PageableDefault(size = 5) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        model.addAttribute("employeeList", this.employeeService.findAllEmployees(keyWordValue, pageable));
        model.addAttribute("positionList",this.iPositionService.findAllPosition());
        model.addAttribute("educationList",this.iEducationDegreeService.findAllEducation());
        model.addAttribute("divisionList",this.iDivisionService.findAllDivision());
        model.addAttribute("keyWordValue");
        return ("/employee/list");
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes redirectAttributes){
       employeeService.deleteId(id);
        redirectAttributes.addFlashAttribute("message", " Delete successfully! ");
        return "redirect:/employee";

    }
}
