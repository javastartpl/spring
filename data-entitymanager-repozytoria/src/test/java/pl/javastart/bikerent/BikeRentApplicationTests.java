package pl.javastart.bikerent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BikeRentApplicationTests {

    @Autowired
    private BikeRepository bikeRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldSaveEntity() {
        Bike bike = new Bike(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        bikeRepository.save(bike);
        assertTrue(bikeRepository.findById(1L).isPresent());
    }

}
