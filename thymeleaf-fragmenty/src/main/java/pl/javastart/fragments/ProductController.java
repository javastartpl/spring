package pl.javastart.fragments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        List<Product> allProducts = productRepository.findAll();
        model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping("/product")
    String getProduct(@RequestParam Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(value -> model.addAttribute("product", value));
        return "product";
    }
}
