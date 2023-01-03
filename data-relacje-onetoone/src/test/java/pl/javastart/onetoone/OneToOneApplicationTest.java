package pl.javastart.onetoone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OneToOneApplicationTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldPersistUserWithDetails() {
        UserDetails userDetails = new UserDetails("Jan", "Kowalski", "Wrocław, 50-503, ul. Legnicka 32/16");
        userDetailsRepository.save(userDetails);
        User user = new User("johnkowal", "strongpassword1", "johnkowal@example.com", userDetails);
        userRepository.save(user);

        assertTrue(userRepository.findById(1L).isPresent());
        assertTrue(userDetailsRepository.findById(1L).isPresent());
    }
}
