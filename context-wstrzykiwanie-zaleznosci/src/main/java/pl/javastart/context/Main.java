package pl.javastart.context;

public class Main {

    public static void main(String[] args) {
        SimpleMessageProducer messageProducer = new SimpleMessageProducer();
        MessagePrinter firstMessagePrinter = new MessagePrinter(messageProducer);
        MessagePrinter secondMessagePrinter = new MessagePrinter(messageProducer);
        firstMessagePrinter.printMessage();
        secondMessagePrinter.printMessage();
    }

}
