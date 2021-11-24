package pl.javastart.onetoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class OneToOneApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToOneApplication.class, args);
        //zapisujemy informacje o użytkowniku i jego szczegółach
        UserDetails userDetails = new UserDetails("Jan", "Kowalski", "Wrocław, 50-503, ul. Legnicka 32/16");
        UserDetailsRepository userDetailsRepository = context.getBean(UserDetailsRepository.class);
        userDetailsRepository.save(userDetails);

        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User("johnkowal", "strongpassword1", "johnkowal@example.com", userDetails);
//        User user2 = new User("eric", "pass123", "eric@example.com", userDetails);
        userRepository.save(user);
//        userRepository.save(user2);

        //odczytujemy informacje o użytkowniku
        Optional<User> firstUser = userRepository.findById(1L);
        System.out.println("Informacje o pierwszym użytkowniku:");
        firstUser.ifPresent(System.out::println);
        System.out.println("Szczegóły pierwszego użytkownika:");
        firstUser.map(User::getUserDetails).ifPresent(System.out::println);

        System.out.println("Szczegóły pierwszego użytkownika pobrane z bazy:");
        Optional<UserDetails> firstDetails = userDetailsRepository.findById(1L);
        firstDetails.ifPresent(System.out::println);
        System.out.println("Użytkownik powiązany ze szczegółami:");
        firstDetails.map(UserDetails::getUser).ifPresent(System.out::println);
    }

}
