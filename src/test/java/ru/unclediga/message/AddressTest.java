package ru.unclediga.message;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class AddressTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void onExit() {
        validatorFactory.close();
    }

    @Test
    public void noViolations() {
        for (Address address : TestData.getAdresses()) {
            final Set<ConstraintViolation<Address>> violations = validator.validate(address);
            Util.printViolations(violations);
            Assert.assertEquals(0, violations.size());
        }
    }

    @Test
    public void violationCountryCode() {
        for (Address address : TestData.getAdresses()) {
            address.setCountryCode("11");
            final Set<ConstraintViolation<Address>> violations = validator.validate(address);
            Assert.assertEquals(2, violations.size());
        }
    }

    @Test
    public void violationRegionCode() {
        for (Address address : TestData.getAdresses()) {
            address.setRegionCode("110");
            final Set<ConstraintViolation<Address>> violations = validator.validate(address);
            Assert.assertEquals(1, violations.size());
        }
    }
}
