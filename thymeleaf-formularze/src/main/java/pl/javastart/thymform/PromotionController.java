package pl.javastart.thymform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class PromotionController {
    private final PromotionRepository promotionRepository;

    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @GetMapping("/")
    String promotionList(Model model) {
        model.addAttribute("promotions", promotionRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    String addForm(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "add-form";
    }

    @PostMapping("/save")
    String savePromotion(Promotion promotion) {
        promotionRepository.add(promotion);
        return "redirect:/";
    }

}
