package com.code_gym.castudy.controller;

import com.code_gym.castudy.model.Contract;
import com.code_gym.castudy.service.IContractService;
import com.code_gym.castudy.service.ICustomerService;
import com.code_gym.castudy.service.IEmployeeService;
import com.code_gym.castudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/contract")
    public String contract(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contractList", iContractService.findByNameContract(pageable));
        model.addAttribute("facility", iFacilityService.findAllFacility());
        model.addAttribute("customers", iCustomerService.findAllCustomer());
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("contract", new Contract());
        return ("/contract/list-contract");
    }

    @GetMapping("/contract/showCreate")
    public String showContract(Model model) {
        model.addAttribute("contractList", new Contract());
        model.addAttribute("facility", iFacilityService.findAllFacility());
        model.addAttribute("customers", iCustomerService.findAllCustomer());
        model.addAttribute("employee", employeeService.findAll());
        return "/contract/create";
    }

    @PostMapping("/contract/create/save")
    public String saveContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message","Successfully Create");
        return ("redirect:/contract");

    }
}
