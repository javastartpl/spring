package pl.javastart.userbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserbaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserbaseApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.save(new User("Jan", "Kowalski", 25));
        userRepository.save(new User("Marta", "Jankowska", 22));
        userRepository.save(new User("Patryk", "Borowski", 34));
    }

}
