package ru.unclediga.message;

import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello == Привет!");
        System.out.println("user.country:" + System.getProperty("user.country"));
        System.out.println("user.language:" + System.getProperty("user.language"));

        Address address = TestData.getAddress();
        // localized validate messages
        //VM options  -Duser.country=RU -Duser.language=ru
        address.countryCode = "11";
        address.rayon = "R";
        address.town = "T";
        address.point = "P";
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        final Validator validator = validatorFactory.getValidator();
        final Set<ConstraintViolation<Address>> violations = validator.validate(address);
        if (violations.isEmpty()) {
            System.out.println("No validation errors");
        } else {
            for (ConstraintViolation<Address> violation : violations) {
                Util.printViolation(violation);
            }
        }
        validatorFactory.close();
    }
}
