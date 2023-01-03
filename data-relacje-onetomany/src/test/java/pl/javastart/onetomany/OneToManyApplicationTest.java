package pl.javastart.onetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OneToManyApplicationTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientOrderRepository clientOrderRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldPersistClientWithTwoOrders() {
        Client client = new Client("Jan", "Kowalski", "Wysoka 40, 12-345 Chałupkowo");
        clientRepository.save(client);
        ClientOrder order1 = new ClientOrder("Szafa modułowa", "Szafa modułowa BigBox z drzwiami przesuwnymi, 160x240cm", 1900.0, client);
        ClientOrder order2 = new ClientOrder("Łóżko", "Łóżko 160x200 z podnoszonym stelażem i skrzynią", 3200.0, client);
        clientOrderRepository.save(order1);
        clientOrderRepository.save(order2);

        assertTrue(clientRepository.findById(1L).isPresent());
        assertEquals(2, clientOrderRepository.count());
    }
}
