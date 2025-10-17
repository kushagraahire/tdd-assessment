package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Integer> nums = Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .toList();

        List<Integer> negatives = nums.stream()
                .filter(n -> n < 0).toList();

        if(!negatives.isEmpty()){
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives.stream().map(String :: valueOf).collect(Collectors.joining(",")));
        }
        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}
