package pl.javastart.instructions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ExampleController {

    @GetMapping("/")
    String example(Model model) {
        model.addAttribute(new Person("John", "Kowalski", 21));
        model.addAttribute("lang", "es");
        return "example";
    }
}
