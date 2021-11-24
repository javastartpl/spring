package pl.javastart.context;

public class MessagePrinter {

    private final MessageProducer messageProducer; //zmieniony typ

    public MessagePrinter(MessageProducer messageProducer) { //zmieniony typ
        this.messageProducer = messageProducer;
    }

    public void printMessage() {
        String message = messageProducer.getMessage();
        System.out.println(message);
    }
}
