package pl.javastart.userbase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class UserbaseApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldNotThrowOnInsert() {
        User user = new User("Jan", "Kowalski", 25);
        assertDoesNotThrow(() -> userRepository.save(user));
    }

}
