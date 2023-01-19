package pl.javastart.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.Set;

@SpringBootApplication
public class ValidationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ValidationApplication.class, args);
		ClientService clientService = ctx.getBean(ClientService.class);
		Client client = new Client("Jan", "Kowalski", "kowaljan@abc.com", -10);
		try {
			clientService.register(client);
			System.out.println("Rejestracja powiodła się: " + client);
		} catch(ConstraintViolationException cve) {
			Set<ConstraintViolation<?>> errors = cve.getConstraintViolations();
			System.out.printf("Rejestracja nie powiodła się %s\n", client);
			errors.stream()
					.map(err -> " >" + err.getPropertyPath() + " " + err.getInvalidValue() + " " + err.getMessage())
					.forEach(System.out::println);
		}
	}

}
