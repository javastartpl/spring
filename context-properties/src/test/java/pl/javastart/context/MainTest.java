package pl.javastart.context;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.javastart.context.producer.MessageProducer;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("file")
class MainTest {

    @Autowired
    private MessageProducer messageProducer;

    @Test
    void contextLoads() {
        System.setIn(new ByteArrayInputStream("message.txt".getBytes()));
        String messageInFile = messageProducer.getMessage();
        assertEquals(
                "Ten komunikat znajduje się w pliku message.txt, który jest w głównym katalogu projektu.",
                messageInFile);
    }
}
