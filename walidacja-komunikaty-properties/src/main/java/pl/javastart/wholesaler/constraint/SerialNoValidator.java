package pl.javastart.wholesaler.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SerialNoValidator implements ConstraintValidator<SerialNo, String> {
    private String startsWith;
    private int codeLength;

    @Override
    public void initialize(SerialNo constraintAnnotation) {
        startsWith = constraintAnnotation.startsWith();
        codeLength = constraintAnnotation.codeLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return checkPrefix(value) && checkCodeLength(value) && checkCode(value);
    }

    private boolean checkPrefix(String serialNumber) {
        return serialNumber.startsWith(startsWith);
    }

    private boolean checkCodeLength(String serialNumber) {
        int prefixLength = startsWith.length();
        int serialNumberLength = serialNumber.length();
        return serialNumberLength - prefixLength == codeLength;
    }

    private boolean checkCode(String serialNumber) {
        int prefixLength = startsWith.length();
        char[] serialNumberCode = serialNumber.substring(prefixLength).toCharArray();
        for (char c : serialNumberCode) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
