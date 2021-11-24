package pl.javastart.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
class MessagePrinterConfig {
    private final String decorator;

    MessagePrinterConfig(@Value("${app.message.decorator}") String decorator) {
        this.decorator = decorator;
    }

    Function<String, String> getDecorator() {
        if (decorator.equals("UPPERCASE")) {
            return String::toUpperCase;
        } else if (decorator.equals("LOWERCASE")) {
            return String::toLowerCase;
        }
        throw new InvalidDecoratorException("No decorator found for " + decorator);
    }
}
