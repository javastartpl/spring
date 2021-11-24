package pl.javastart.valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PersonValidatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PersonValidatorApplication.class, args);

        PersonService personService = context.getBean(PersonService.class);
        Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
        System.out.println("Dodaję " + person1);
        personService.addPerson(person1); //ok

        Person person2 = new Person("Anna", null, "dobryemail@example.com", 22);
        System.out.println("Dodaję " + person2);
        personService.addPerson(person2); //not ok

        Person person3 = new Person("Piotr", "Kaleta", "zlyEmail", 0);
        System.out.println("Dodaję " + person3);
        personService.addPerson(person3); //not ok

        System.out.println("Osoby w bazie " + personService.getPeople().size());
        for (Person p : personService.getPeople()) {
            System.out.println(p);
        }

        context.close();
    }

}
