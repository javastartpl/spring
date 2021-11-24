package pl.javastart.calc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class CalculatorController {

    @PostMapping("/calc")
    @ResponseBody
    String calc(@RequestParam double a, @RequestParam double b, @RequestParam String operator) {
        try {
            double result = CalculatorService.calculate(a, b, operator);
            return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
