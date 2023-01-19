package pl.javastart.valid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonValidatorApplicationTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Autowired
    PersonService personService;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void shouldAddPerson() {
        Person person = new Person("Jan", "Kowalski", "jan@kowalski.org", 23);
        personService.addPerson(person);
        assertEquals(">Obiekt został dodany", outputStreamCaptor.toString().trim());
    }

    @Test
    void shouldNotAddPersonWithIncorrectEmailAndAge() {
        Person person = new Person("Jan", "Kowalski", "jan", -5);
        personService.addPerson(person);
        String output = outputStreamCaptor.toString();
        boolean errors = output.contains(">>> age must be greater than or equal to 1 (-5)")
                && output.contains(">>> email must be a well-formed email address (jan)");
        assertTrue(errors);
    }
}
