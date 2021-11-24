package pl.javastart.calc;

class CalculatorService {
    static double calculate(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Nieobsługiwany operator matematyczny");
        };
    }
}
