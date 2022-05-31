package pl.javastart.random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class HomeController {

    private final RandomNumberService randomNumberService;

    public HomeController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @GetMapping("/")
    String home(@RequestParam int from, @RequestParam int to, Model model) {
        int randomNumber = randomNumberService.generateRandomInRange(from, to);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("randomNumber", randomNumber);
        return "index";
    }
}
