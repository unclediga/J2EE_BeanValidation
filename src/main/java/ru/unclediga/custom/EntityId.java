package ru.unclediga.custom;

import ru.unclediga.custom.validator.EntityIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EntityIdValidator.class)
public @interface EntityId {
    String message() default "Entity ID not match to template";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int prefixSize() default 2;

    int numberSize() default 3;


}
