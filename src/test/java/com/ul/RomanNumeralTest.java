package com.ul;

import com.ul.roman.service.RomanNumeralServiceDefault;
import com.ul.roman.utils.enums.RomanEnum;
import java.util.List;
import java.util.stream.Collectors;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanNumeralTest {

    @Autowired
    RomanNumeralServiceDefault romanService;

    private String convertIntToRoman(int value) {
        // Integer indexCounter = 0;
        // String romanValue = "";
        return romanService.convertFromIntToRoman(value);
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
    
    // lembrar 4 (IV), 9 (IX)
    
    /** The following code should not be changed.
     *  It is there to help you on your test execution
     */
    @Test
    void testRomanValues(){
        System.out.println("3 = " + this.convertIntToRoman(3));
        Assert.assertEquals("III", this.convertIntToRoman(3));
        System.out.println("4 = " + this.convertIntToRoman(4));
        Assert.assertEquals("IV", this.convertIntToRoman(4));
        System.out.println("9 = " + this.convertIntToRoman(9));
        Assert.assertEquals("IX", this.convertIntToRoman(9));
        System.out.println("58 = " + this.convertIntToRoman(58));
        Assert.assertEquals("LVIII", this.convertIntToRoman(58));
        System.out.println("1994 = " + this.convertIntToRoman(1994));
        Assert.assertEquals("MCMXCIV", this.convertIntToRoman(1994));
    }
}