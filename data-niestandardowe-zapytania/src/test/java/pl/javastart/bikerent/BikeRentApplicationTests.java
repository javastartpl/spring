package pl.javastart.bikerent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BikeRentApplicationTests {

    @Autowired
    private BikeService bikeService;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldRentNewBike() {
        BikeDto bike = new BikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        bikeService.add(bike);
        double payment = bikeService.rentForHours("KRS12345", 5, "ABC999");
        assertEquals(150, payment);
    }

    @Test
    void shouldNotRentNonExistentBike() {
        assertThrowsExactly(BikeNotFoundException.class, () -> bikeService.rentForHours("NOTEXIST123", 5, "ABC999"));
    }

}
