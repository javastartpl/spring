package pl.javastart.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("client", new ClientDto());
        return "index";
    }

    @PostMapping("/register")
    String register(@Valid @ModelAttribute("client") ClientDto clientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            clientService.register(clientDto);
            return "redirect:success";
        }
    }
    
    @GetMapping("/success")
    String success() {
        return "success";
    }
}
