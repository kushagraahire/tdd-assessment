import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Calculator.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setup(){
        resetCounter();
        calculator = new Calculator();
    }

    @Test
    void addEmptyNumber(){
        assertEquals(0, calculator.add(""));
    }

    @Test
    void addSingleNumber(){
        assertEquals(2, calculator.add("2"));
    }

    @Test
    void addTwoNumber(){
        assertEquals(3,calculator.add("1,2"));
    }

    @Test
    void addHandleNewLine(){
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void addHandleCustomDelimiter(){
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void addHandleNegativeNumberThrowException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("1,-2,3"));
        assertEquals("negative numbers not allowed: -2", exception.getMessage());
    }

    @Test
    void addHandleMultipleNegativeNumberThrowException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,-2,3"));
        assertEquals("negative numbers not allowed: -1,-2", exception.getMessage());
    }

    @Test
    void addCounter(){
        calculator.add("1,2,3");
        assertEquals(1, getTotalCalledCount());
    }

    @Test
    void addNumbersGreaterThan1000AreIgnored(){
        assertEquals(2, calculator.add("2,1001"));
        assertEquals(1002, calculator.add("2,1000"));
    }
}
