package pl.javastart.auctions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuctionsApplicationTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldFindAvgPrice() {
        Auction auction1 = new Auction("Laptop Dell Inspirion", "Niezawodny i szybki komputer do biura i domu", 1500.0, 4999.0);
        Auction auction2 = new Auction("Macbook Pro 15 2020", "Komputer uwielbiany przez miliony", 5000.0, 7999.0);
        Auction auction3 = new Auction("Lenovo Probook 15", "Laptop, który zapewni Ci wygodną pracę", 2999.0, 5999.0);
        Category category1 = new Category("Laptopy", "Znajdź komputer idealny dla siebie");
        category1.addAuction(auction1);
        category1.addAuction(auction2);
        category1.addAuction(auction3);
        categoryRepository.save(category1);
        double avgPrice = categoryRepository.getAvgPriceForCategory(1L).orElseThrow();
        assertEquals(6332.333333333333, avgPrice);
    }
}
