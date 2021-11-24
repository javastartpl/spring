package pl.javastart.onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OneToManyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToManyApplication.class, args);
        Client client = new Client("Jan", "Kowalski", "Wysoka 40, 12-345 Chałupkowo");
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        clientRepository.save(client);

        ClientOrder order1 = new ClientOrder("Szafa modułowa", "Szafa modułowa BigBox z drzwiami przesuwnymi, 160x240cm", 1900.0, client);
        ClientOrder order2 = new ClientOrder("Łóżko", "Łóżko 160x200 z podnoszonym stelażem i skrzynią", 3200.0, client);
        ClientOrderRepository clientOrderRepository = context.getBean(ClientOrderRepository.class);
        clientOrderRepository.save(order1);
        clientOrderRepository.save(order2);
    }
}
