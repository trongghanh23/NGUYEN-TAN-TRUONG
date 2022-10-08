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
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("contract", new Contract());
        return ("/contract/list-contract");
    }

    @PostMapping("/save")
    public String addContract(Contract contract) {
        iContractService.save(contract);
        return ("redirect:/contract");

    }
}
