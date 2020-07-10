package ru.unclediga.multiple;

import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        final Validator validator = validatorFactory.getValidator();
        final List<Address> adresses = TestData.getAdresses();
        validateAddresses(validator, adresses, AddressType.FIASGROUP.class);
        validateAddresses(validator, adresses, AddressType.KLADRGROUP.class);
        validateAddresses(validator, adresses, Default.class);
        validatorFactory.close();
    }

    public static void validateAddresses(Validator validator, List<Address> addresses, Class group) {
        System.out.println("==== Group: " + group.getName());
        int violationCount = 0;
        for (Address address : addresses) {
            final Set<ConstraintViolation<Address>> violations =
                    validator.validate(address, group);
            violationCount += violations.size();
            violations.forEach(Util::printViolation);
        }
        System.out.println("=== Total violations count: " + violationCount);
    }
}
