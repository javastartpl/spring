package pl.javastart.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidationApplicationTest {

    @Autowired
    ClientService clientService;

    @Test
    void contextLoads() {

    }

    @Test
    @DisplayName("Should throw ConstraintViolationException for client with invalid age")
    void shouldNotPersistInvalidClient() {
        Client client = new Client("Jan", "Kowalski", "kowaljan@abc.com", -10);
        assertThrows(ConstraintViolationException.class, () -> clientService.register(client));
    }

    @Test
    void shouldPersistValidClient() {
        Client client = new Client("Jan", "Kowalski", "kowaljan@abc.com", 10);
        assertDoesNotThrow(() -> clientService.register(client));
    }
}
