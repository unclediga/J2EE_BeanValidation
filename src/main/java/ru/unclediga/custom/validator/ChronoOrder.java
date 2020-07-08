package ru.unclediga.custom.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ChronoOrderValidator.class)
public @interface ChronoOrder {
    String message() default "dates should be in chronological order";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
