package pl.javastart.context;

import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.Scanner;

@Controller
class MessageController {

    private final Scanner scanner;
    private final MessagePrinter messagePrinter;

    public MessageController(Scanner scanner, MessagePrinter messagePrinter) {
        this.scanner = scanner;
        this.messagePrinter = messagePrinter;
    }

    public void mainLoop() {
        Option option;
        do {
            option = chooseOption();
            executeOption(option);
        } while (option != Option.EXIT);
    }

    private void executeOption(Option option) {
        switch (option) {
            case NEXT_MESSAGE -> printMessage();
            case EXIT -> exit();
        }
    }

    private void printMessage() {
        messagePrinter.printMessage();
    }

    private void exit() {
        System.out.println("Koniec programu. Do zobaczenia!");
    }

    private Option chooseOption() {
        int optionNumber;
        Optional<Option> option;
        do {
            printOptions();
            System.out.println("Wybierz numer opcji:");
            optionNumber = scanner.nextInt();
            scanner.nextLine();
            option = Option.fromInt(optionNumber);
        } while (option.isEmpty());
        return option.get();
    }

    private void printOptions() {
        Option[] options = Option.values();
        System.out.println("Opcje:");
        for (Option option : options) {
            System.out.println(option);
        }
    }

    private enum Option {
        EXIT(0, "Wyjście z programu"),
        NEXT_MESSAGE(1, "Wczytaj kolejny komunikat");

        private final int number;
        private final String description;

        Option(int number, String description) {
            this.number = number;
            this.description = description;
        }

        static Optional<Option> fromInt(int number) {
            Option[] options = Option.values();
            if (number >= 0 && number < options.length)
                return Optional.of(Option.values()[number]);
            else
                return Optional.empty();
        }

        @Override
        public String toString() {
            return number + " - " + description;
        }
    }
}
