import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }
}
