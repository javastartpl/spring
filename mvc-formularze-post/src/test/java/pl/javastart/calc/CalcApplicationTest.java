package pl.javastart.calc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalcApplicationTest {

    @Autowired
    CalculatorController calculatorController;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldAddTwoNumbers() {
        String result = calculatorController.calc(5.00, 10.00, "+");
        assertEquals("5.00 + 10.00 = 15.00", result);
    }
}
