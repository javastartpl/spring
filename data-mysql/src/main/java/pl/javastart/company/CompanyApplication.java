package pl.javastart.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        Employee employee1 = new Employee("Jan", "Kowalski", 3000.0);
        Employee employee2 = new Employee("Marta", "Zalewska", 4000.0);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        new Scanner(System.in).nextLine();
    }

}
