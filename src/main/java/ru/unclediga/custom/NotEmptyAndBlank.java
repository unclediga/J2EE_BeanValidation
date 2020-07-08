package ru.unclediga.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@NotNull
@Size(min = 1)
@Constraint(validatedBy = {})
public @interface NotEmptyAndBlank {
    String message() default "value should be not null and not blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
