package pl.javastart.vatcalc;

import org.springframework.stereotype.Service;

@Service
class VatCalculatorService {
    VatDto calculateVat(double nettoPrice, String category) {
        double vat = calculateVatAmount(nettoPrice, category);
        double bruttoPrice = nettoPrice + vat;
        return new VatDto(nettoPrice, bruttoPrice, vat);
    }

    private double calculateVatAmount(double nettoPrice, String category) {
        double vatRate = switch (category) {
            case "service" -> 0.23;
            case "food" -> 0.05;
            default -> 0.15;
        };
        return nettoPrice * vatRate;
    }
}
