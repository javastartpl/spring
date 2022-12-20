package pl.javastart.context;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("file")
class MainTest {
    @Test
    void contextLoads() {
    }
}
