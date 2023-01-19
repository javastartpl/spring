package pl.javastart.emailapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailApplicationTest {

    @Autowired
    EmailService emailService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void contextLoads() {

    }

    @Test
    void shouldNotSendEmailWithBadWords() {
        EmailMessage message = new EmailMessage(
                "abc@abc.com",
                "xyz@xyz.com",
                "Hejo! Co tam kurka u Ciebie słychać wariacie? Pozdro"
        );
        emailService.sendMessage(message);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("message : Text contains bad words"));
    }
}
