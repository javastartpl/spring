package pl.javastart.shop;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> getProducts(@RequestParam(required = false) String name) {
        if (name == null) {
            return productRepository.findAll();
        } else {
            return productRepository.findAllByName(name);
        }
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("/{id}/producer")
    Producer getProducerByProductId(@PathVariable Integer id) {
        return productRepository.findById(id).getProducer();
    }
}
