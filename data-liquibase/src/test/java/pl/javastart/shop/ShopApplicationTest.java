package pl.javastart.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class ShopApplicationTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
        assertNotNull(productRepository);
    }

    @Test
    void shouldLoadTestDataFromDataSqlFile() {
        long productCount = productRepository.count();
        assertEquals(5, productCount);
    }
}
