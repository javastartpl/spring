package pl.javastart.context;

public class Main {
    public static void main(String[] args) {
        MessageProducer messageProducer = new ConsoleMessageProducer();
        MessagePrinter messagePrinter = new MessagePrinter(messageProducer);
        messagePrinter.printMessage();
    }
}
