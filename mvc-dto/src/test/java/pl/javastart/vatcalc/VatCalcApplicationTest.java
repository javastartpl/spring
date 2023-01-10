package pl.javastart.vatcalc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VatCalcApplicationTest {

    @Autowired
    VatController vatController;

    @Test
    void contextLoads() {
        assertNotNull(vatController);
    }
}
