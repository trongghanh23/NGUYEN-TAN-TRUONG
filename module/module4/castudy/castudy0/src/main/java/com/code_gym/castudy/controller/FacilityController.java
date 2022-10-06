package com.code_gym.castudy.controller;

import com.code_gym.castudy.dto.FacilityDto;
import com.code_gym.castudy.model.facility.Facility;
import com.code_gym.castudy.service.IFacilityService;
import com.code_gym.castudy.service.IFacilityTypeService;
import com.code_gym.castudy.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/facility")
    public String customerList(Model model, @PageableDefault(size = 5) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        model.addAttribute("facility", this.iFacilityService.findAllSearchAndPaging(keyWordValue, pageable));
        model.addAttribute("keyWordValue");
        return ("/facility/list");
    }

    @GetMapping("/facility/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("showFacilityType", this.iFacilityTypeService.findAll());
        model.addAttribute("showRentType", this.iRentTypeService.findAll());
        return ("/facility/create");
    }

    @PostMapping("/create/save/facility")
    public String save(@ModelAttribute("facilityDto") @Validated FacilityDto facilityDto ,
                       BindingResult bindingResult,Model model,
                       RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("showFacilityType", this.iFacilityTypeService.findAll());
            model.addAttribute("showRentType", this.iRentTypeService.findAll());
            return ("/facility/create");

        } else {

            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            this.iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", " Add new successfully! ");
            return "redirect:/facility";
        }
    }

    @PostMapping("/delete/facility")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        this.iFacilityService.delete(id);
        redirectAttributes.addFlashAttribute("message", " Delete successfully! ");

        return "redirect:/facility";
    }

    @GetMapping("/showUpdate/facility")
    public String showEditFacility(@RequestParam Integer id, Model model) {


        model.addAttribute("facilityUpdate", iFacilityService.getId(id));
        model.addAttribute("showFacilityType", iFacilityTypeService.findAll());
        model.addAttribute("showRentType", iRentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/update/facility")
    public String updateFacility(@ModelAttribute("facilityUpdate") @Validated FacilityDto facilityDto ,
    BindingResult bindingResult,Model model,
    RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("showFacilityType", this.iFacilityTypeService.findAll());
            model.addAttribute("showRentType", this.iRentTypeService.findAll());
            return "/facility/edit";

        } else {

            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            this.iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Update successfully!");
            return "redirect:/facility";
        }

    }

}