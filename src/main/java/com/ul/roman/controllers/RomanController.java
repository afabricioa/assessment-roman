package com.ul.roman.controllers;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    ResponseEntity convertRomanToInt(String value) {
        try{
            if(!romanService.isValidRoman(value)){
                throw new Exception("The Roman number you provided is incorrect.");
            }
            Integer resultValue = romanService.convertRomanToInt(value.toUpperCase());
            return ResponseEntity.status(HttpStatus.OK).body(value + " = " + resultValue);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
    @GetMapping("/convertIntToRoman")
    ResponseEntity convertIntToRoman(int value) {
        try{
            if(value < 0 || value > 3999){
                throw new Exception("The Integer number you provided is incorrect.");
            }
            String result = romanService.convertFromIntToRoman(value);
            return ResponseEntity.status(HttpStatus.OK).body(value + " = " + result);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
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
            System.out.println(filePath);
            byte[] fileContent = Files.readAllBytes(filePath); 
            return ResponseEntity.status(200).headers(headers).body(fileContent);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
