package pl.javastart.manytomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ManyToManyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ManyToManyApplication.class, args);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        ClientOrderRepository orderRepository = context.getBean(ClientOrderRepository.class);

        Product product1 = new Product("mleko", 3.2, "Pyszne mleko od polskiej krowy");
        Product product2 = new Product("czekolada", 2.8, "Mleczna i słodka czekolada z najlepszego mleka");
        Product product3 = new Product("masło", 4.99, "Prawdziwe masło, idealne do smarowania i wypieków");
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        ClientOrder order1 = new ClientOrder("Zakupy na dane Jan Kowalski, 12-345 Warszawa, Wysoka 10/6");
        ClientOrder order2 = new ClientOrder("Zakupy na dane Marta Zawadzka, 23-345 Kraków, Niska 2/1");
        order1.addProduct(product1);
        order1.addProduct(product2);
        order2.addProduct(product2);
        order2.addProduct(product3);
        orderRepository.save(order1);
        orderRepository.save(order2);

//        orderRepository.findById(1L).ifPresent(System.out::println);
    }
}
