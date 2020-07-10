package ru.unclediga.payload;

import ru.unclediga.Util;

import javax.validation.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final Address address = TestData.getAddress();
        address.setCountryCode(null);
        address.setRegionCode(null);
        address.setTown(null);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        final Validator validator = validatorFactory.getValidator();
        final Set<ConstraintViolation<Address>> violations = validator.validate(address);
        if (violations.isEmpty()) {
            System.out.println("No validation errors");
        } else {
            for (ConstraintViolation<Address> violation : violations) {
                Util.printViolation(violation);
                final Set<Class<? extends Payload>> payloads = violation.getConstraintDescriptor().getPayload();
                System.out.println("Payloads:" + payloads);
            }
        }
        validatorFactory.close();
    }
}
