package pl.javastart.context.producer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Profile("console")
public class ConsoleMessageProducer implements MessageProducer {
    private final Scanner scanner;

    public ConsoleMessageProducer(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getMessage() {
        System.out.println("Wpisz dowolny tekst:");
        return scanner.nextLine();
    }
}
