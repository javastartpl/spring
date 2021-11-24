package pl.javastart.urls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
class HomeController {

    private final PictureRepository pictureRepository;

    public HomeController(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        Collection<Picture> pictures = pictureRepository.findAll();
        model.addAttribute("pictures", pictures);
        return "index";
    }
}
