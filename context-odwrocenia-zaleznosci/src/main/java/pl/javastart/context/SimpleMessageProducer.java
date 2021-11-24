package pl.javastart.context;

class SimpleMessageProducer implements MessageProducer { //dodana implementacja interfejsu
    public String getMessage() {
        return "Example message " + System.currentTimeMillis();
    }
}
