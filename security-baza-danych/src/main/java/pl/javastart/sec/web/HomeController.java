package pl.javastart.sec.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.sec.message.WelcomeMessageService;

@Controller
class HomeController {
    private final WelcomeMessageService welcomeMessageService;

    public HomeController(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    @GetMapping("/")
    String home(@RequestParam(defaultValue = "en") String lang, Model model) {
        String welcomeMessage = welcomeMessageService.getWelcomeMessage(lang);
        model.addAttribute("lang", lang);
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "index";
    }

}
