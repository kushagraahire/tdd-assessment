import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setup(){
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

}
