package ru.unclediga.custom;

import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Dept dept = TestData.getDept();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        final Validator validator = validatorFactory.getValidator();
        final Set<ConstraintViolation<Dept>> violations = validator.validate(dept);
        if (violations.isEmpty()) {
            System.out.println("No validation errors");
        } else {
            for (ConstraintViolation<Dept> violation : violations) {
                Util.printViolation(violation);
            }
        }
        validatorFactory.close();
    }
}
