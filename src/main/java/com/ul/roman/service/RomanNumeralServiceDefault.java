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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralServiceDefault {

    @Value("${integer.list.file}")
    private String fileName;

    @Value("${path.to.save.file}")
    private String pathToSave;

    public void convertFromFileIntToRoman() {
        URL resource = getClass().getClassLoader().getResource(fileName);
        Path path = Paths.get(resource.getPath());
        try {
        final Stream<String> allLines = Files.lines(path);
            final List<String> listToSave = allLines
                    .map(lines -> {
                        String romanValue = convertFromIntToRoman(Integer.parseInt(lines));
                        return lines + " - " + romanValue + "\n";
                    }).collect(Collectors.toList());
            
            FileWriter fileWriter = new FileWriter(pathToSave + "/RomanNumber.txt");
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

    public Integer convertRomanToInt(String value){
        Integer indexCounter = 0;
        Integer romanValue = 0;
        return converterRomanToInt(value, indexCounter, romanValue);
    }

    Integer converterRomanToInt(String value, Integer index, Integer result){
        List<RomanEnum> romanValues = RomanEnum.getSortedValues();
        String testedRomanValue = romanValues.get(index).name();
        
        if(value.contains(testedRomanValue) && value.indexOf(testedRomanValue, 0) == 0){
            result += romanValues.get(index).getValue();

            if(testedRomanValue.length() == 1){
                return converterRomanToInt(value.substring(1, value.length()), index, result);
            } else if(testedRomanValue.length() == 2){
                return converterRomanToInt(value.substring(2, value.length()), index, result);
            }
        }else if(value != ""){
            return converterRomanToInt(value, index + 1, result);
        }

        return result;
    }

    public Boolean isValidRoman(String romanValue){
        List<Character> validRomanNumber = List.of('I', 'V', 'X', 'L', 'C', 'D', 'M');

        if(StringUtils.isBlank(romanValue)){
            return false;
        }

        if(!isValidSequence(romanValue)){
            return false;
        }
        
        for(int i = 0; i < romanValue.length(); i++){
            char current = romanValue.charAt(i);

            if(!validRomanNumber.contains(current)){
                return false;
            }
        }

        return true;
    }

    public Boolean isValidSequence(String roman){
        List<String> invalidSequences = List.of("IIII", "VV", "XXXX", "LL", "CCCC", "DD", "MMMM");
        
        for(String sequence : invalidSequences){
            if(roman.contains(sequence)){
                return false;
            }
        }
        return true;
    }
}
