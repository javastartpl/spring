package pl.javastart.context;

class SimpleMessageProducer {
    String getMessage() {
        return "Example message " + System.currentTimeMillis();
    }
}
