package ru.unclediga.message;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Size(min = 2, max = 2)
@Pattern(regexp = "[0-9][0-9]")
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface RegionId {

        String message() default "code must contain exactly 2 digits";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

}
