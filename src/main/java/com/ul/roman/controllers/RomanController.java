package com.ul.roman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.ul.roman.service.RomanNumeralServiceDefault;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/roman")
public class RomanController {
    
    @Autowired
    RomanNumeralServiceDefault romanService;

    @GetMapping("/convertRomanToInt")
    int convertRomanToInt(String value) {
        return 0;
    }
    
    @GetMapping("/convertIntToRoman")
    String convertIntToRoman(int value) {
        return romanService.convertFromIntToRoman(value);
    }
    
    @GetMapping("/convertFileToRoman")
    String convertFileToRoman(){
        romanService.convertFromFileIntToRoman();
        return "t";
    }
}
