package com.ul.roman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ul.roman.service.RomanNumeralServiceDefault;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/roman")
public class RomanController {
    
    @Autowired
    RomanNumeralServiceDefault romanService;

    @GetMapping("/convertRomanToInt")
    int convertRomanToInt(String value) {
        return romanService.convertRomanToInt(value.toUpperCase());
    }
    
    @GetMapping("/convertIntToRoman")
    String convertIntToRoman(int value) {
        return romanService.convertFromIntToRoman(value);
    }
    
    @GetMapping("/convertFileToRoman")
    String convertFileToRoman(){
        romanService.convertFromFileIntToRoman();
        return "success";
    }
}
