package com.nichi.Week_10_Assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.nichi.Week_10_Assignment.Retailer;
import com.nichi.Week_10_Assignment.services.RetailerService;

@Controller
@RequestMapping("jpa")
public class RetailerController {

    @Autowired
    RetailerService RetailerService;
    
    @GetMapping("/Retailers/list")
    @ResponseBody
    public List<Retailer> allRetailers(){      
        return RetailerService.getAllRetailers();
    }  
    
    @PostMapping("/Retailers/add")
    @ResponseBody
    public RedirectView addRetailer(@Valid Retailer Retailer){   
        // Save the Retailer in the DB
        Retailer resultRetailer = RetailerService.addRetailer(Retailer);
        System.out.format("Added Retailer with id = %s", resultRetailer.getRetailer_id());
        
        RedirectView redirectView = new RedirectView("/api/Retailers/list"); 
        return redirectView;
    } 




}
