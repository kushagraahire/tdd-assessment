package org.example;

public class Calculator {
    public int add(String numbers){
        if(numbers.isBlank()){
            return 0;
        }

        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        }

        throw new UnsupportedOperationException("Only empty and single numbers are allowed");
    }
}
