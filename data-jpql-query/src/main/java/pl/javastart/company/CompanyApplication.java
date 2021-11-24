package pl.javastart.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		employeeRepository.save(new Employee(1L, "Jan", "Zenkiewicz", 2000.0));
		employeeRepository.save(new Employee(2L, "Marta", "Dudek", 13000.0));
		employeeRepository.save(new Employee(3L, "Paweł", "Adamczyk", 12500.0));
		employeeRepository.save(new Employee(4L, "Kasia", "Kowalska", 4000.0));

		System.out.println(">>> Pracownicy po podwyżce:");
		employeeRepository.giveRiseToAll();
		employeeRepository.findAll().forEach(System.out::println);

		System.out.println(">>> Bogaci pracownicy:");
		employeeRepository.findRichEmployees().forEach(System.out::println);

		System.out.println(">>> Pracownicy zarabiający pomiędzy 3000zł i 5000zł");
		employeeRepository.findBySalaryInRange(3000, 5000).forEach(System.out::println);
	}

}
