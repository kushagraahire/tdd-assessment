package org.example;

import java.util.Arrays;

public class Calculator {
    public int add(String numbers){
        if(numbers.isBlank()){
            return 0;
        }

        String delimiter = "[,\n]";

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        return Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt).sum();
    }
}
