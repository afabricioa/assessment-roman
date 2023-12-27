package com.ul.roman.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity convertFileToRoman(HttpServletResponse response){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=RomanNumber.txt";
        response.setHeader(headerKey, headerValue);

        romanService.convertFromFileIntToRoman();
        try{
            Path filePath = Paths.get(System.getProperty("user.dir"), "RomanNumber.txt");
            byte[] fileContent = Files.readAllBytes(filePath); 
            return ResponseEntity.status(200).headers(headers).body(fileContent);
        } catch (Exception e) {
            // Lide com exceções, se necessário
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
