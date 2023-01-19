package pl.javastart.wholesaler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.javastart.wholesaler.model.Equipment;
import pl.javastart.wholesaler.model.Product;

import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WholesalerApplicationTest {

    @Autowired
    Validator validator;

    @Test
    void contextLoads() {

    }

    @Test
    void shouldViolateContraintForInvalidSerialNo() {
        Locale.setDefault(Locale.forLanguageTag("en"));
        Product product = new Product("Dell XPS 15", "Laptop 15 calowy z 2021 roku", "PLL13243");
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
        String violationMessage = constraintViolations.iterator().next().getMessage();
        assertAll(
                () -> assertFalse(constraintViolations.isEmpty()),
                () -> assertEquals("PLL13243 is incorrect. It should start with PL and have 5 digit number", violationMessage)
        );
    }

    @Test
    void shouldNotViolateConstraintForValidEquipment() {
        Equipment equipment = new Equipment("iPhone 13", "KARNOW123", "EQ7986");
        Set<ConstraintViolation<Equipment>> constraintViolations = validator.validate(equipment);
        System.out.println(constraintViolations);
        assertTrue(constraintViolations.isEmpty());
    }
}
