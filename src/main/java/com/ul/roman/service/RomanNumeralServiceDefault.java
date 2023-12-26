package com.ul.roman.service;

import com.ul.roman.utils.enums.RomanEnum;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralServiceDefault {
    
    public void convertFromFileIntToRoman() {
        String fileName = "IntegerList.txt";
        URL resource = getClass().getClassLoader().getResource(fileName);
        Path path = Paths.get(resource.getPath());
        try {
        final Stream<String> allLines = Files.lines(path);
            final List<String> listToSave = allLines
                    .map(lines -> {
                        System.out.println(lines);
                        return RomanEnum.I.toString();
                    }).collect(Collectors.toList());
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            listToSave.forEach(el -> printWriter.print(el));
            printWriter.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    public String convertFromIntToRoman(Integer value){
        Integer indexCounter = 0;
        String romanValue = "";

        return converterIntToRoman(value, indexCounter, romanValue);
    }

    String converterIntToRoman(Integer value, Integer index, String result){
        List<RomanEnum> romanValues = RomanEnum.getSortedValues();
        List<Integer> integerValues = romanValues
                                    .stream()
                                    .map(RomanEnum::getValue)
                                    .collect(Collectors.toList());
        Integer testedValue = integerValues.get(index);
        if(value >= testedValue && value > 0){
            result += romanValues.get(index).name();
            return converterIntToRoman(value - testedValue, index, result);
        } else if(value > 0){
            return converterIntToRoman(value, index + 1, result);
        }

        return result;
    }
}
