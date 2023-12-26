package com.ul.roman.utils.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum RomanEnum {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);
    
    private final int value;
    RomanEnum(final int value) {
        this.value=value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public static List<RomanEnum> getSortedValues(){
        List<RomanEnum> values = new ArrayList<>(List.of(RomanEnum.values()));
        values.sort((a,b) -> b.value - a.value);
        return values;
    }
}
