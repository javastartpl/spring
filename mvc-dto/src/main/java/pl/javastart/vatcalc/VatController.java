package pl.javastart.vatcalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class VatController {

    private final VatCalculatorService vatService;

    public VatController(VatCalculatorService vatService) {
        this.vatService = vatService;
    }

    @PostMapping("/calculate")
    String calculate(double nettoPrice, String category,
                     Model model) {
        VatDto vat = vatService.calculateVat(nettoPrice, category);
        model.addAttribute("vat", vat);
        return "result";
    }
}
