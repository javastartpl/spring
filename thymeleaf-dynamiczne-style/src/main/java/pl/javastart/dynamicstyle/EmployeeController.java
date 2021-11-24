package pl.javastart.dynamicstyle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        BigDecimal avgSalary = employeeRepository.getAvgSalary();
        model.addAttribute("employees", employees);
        model.addAttribute("avgSalary", avgSalary);
        return "index";
    }
}
