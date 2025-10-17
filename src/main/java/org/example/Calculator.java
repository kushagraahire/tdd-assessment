package org.example;

import java.util.Arrays;

public class Calculator {
    public int add(String numbers){
        if(numbers.isBlank()){
            return 0;
        }

        return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).sum();
    }
}
