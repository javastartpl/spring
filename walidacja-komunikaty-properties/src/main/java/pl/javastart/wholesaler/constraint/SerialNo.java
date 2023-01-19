package pl.javastart.wholesaler.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = SerialNoValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface SerialNo {
    String message() default "{pl.javastart.constraint.SerialNo.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int codeLength();
    String startsWith();
}
