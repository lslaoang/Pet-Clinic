package com.spring.petclinic.controller;

import com.spring.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(final OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String findOwner(){
        return "notimplemented";
    }

    @RequestMapping({"/find/{ownerId}"})
    public String findOwner(@PathVariable("ownerId") Long id, Model model){
            model.addAttribute("owners",ownerService.findById(id));

        return "owners/index";
    }
}
