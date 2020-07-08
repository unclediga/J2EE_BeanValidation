package ru.unclediga.custom.validator;

import ru.unclediga.custom.EntityId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntityIdValidator implements ConstraintValidator<EntityId, String> {

    private int prefix;
    private int number;

    public void initialize(EntityId constraint) {
        prefix = constraint.prefixSize();
        number = constraint.numberSize();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return obj.contains("-") && obj.indexOf("-") == prefix && (obj.length() - obj.indexOf("-") - 1) == number;
    }
}
