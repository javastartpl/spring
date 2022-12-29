package pl.javastart.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyApplicationTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {}

    @Test
    void shouldFindRichEmployees() {
        employeeRepository.save(new Employee(1L, "Jan", "Zenkiewicz", 2000.0));
        employeeRepository.save(new Employee(2L, "Marta", "Dudek", 13000.0));
        employeeRepository.save(new Employee(3L, "Paweł", "Adamczyk", 12500.0));
        employeeRepository.save(new Employee(4L, "Kasia", "Kowalska", 4000.0));

        List<Employee> richEmployees = employeeRepository.findRichEmployees();
        List<Double> salaries = richEmployees.stream().map(Employee::getSalary).toList();;
        assertAll(
                () -> assertEquals(2, richEmployees.size()),
                () -> assertThat(salaries).allMatch(s -> s > 10_000)
        );
    }
}
