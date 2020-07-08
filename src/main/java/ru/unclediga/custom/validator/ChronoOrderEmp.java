package ru.unclediga.custom.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ChronoOrderEmpValidator.class)
public @interface ChronoOrderEmp {
    String message() default "dates 'hire' and 'fire' should be in chronological order";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
