package pl.javastart.shop;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(
                new Product(1, "Mleko", 3.8, new Producer("Mleczex", new Address("Warszawa", "20-222", "Wysoka 20")))
        );
        products.add(
                new Product(2, "Czekolada mleczna", 4.2, new Producer("Czokoszok", new Address("Wrocław", "50-123", "Kucharska 18")))
        );
        products.add(
                new Product(3, "Kawa rozpuszczalna", 16.99, new Producer("Kaw-Pol", new Address("Kraków", "10-234", "Niska 33")))
        );
    }

    List<Product> findAll() {
        return products;
    }

    List<Product> findAllByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .toList();
    }

    Optional<Product> findById(int id) {
        if (id > products.size() - 1) {
            return Optional.empty();
        } else {
            return Optional.of(products.get(id - 1));
        }
    }
}
