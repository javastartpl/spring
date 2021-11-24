package pl.javastart.expressions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
class HomeController {

    @GetMapping("/")
    String home(Model model) {
        List<Product> products = List.of(
                new Product("mleko", "mlekowita", 3.2),
                new Product("czekolada", "czekoladex", 2.2),
                new Product("jogurt", "jogurtex", 1.29),
                new Product("chleb", "chleboteka", 4.19),
                new Product("pasztet", "mięsny raj", 8.99)
        );
        model.addAttribute("products", products);
        return "index";
    }
}
