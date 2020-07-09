package ru.unclediga.message;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@NotNull
@Size(min = 3, max = 3)
@Pattern(regexp = "[0-9]{3}")
@Constraint(validatedBy = {})
//@ReportAsSingleViolation
public @interface CountryId {
    String message() default "<empty>";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

