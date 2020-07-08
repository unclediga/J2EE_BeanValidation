package ru.unclediga.custom;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DeptTest {
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
    public void TestChronoOrder() {
        System.out.println("== Test @ChronoOrder ==");
        final Dept dept = TestData.getDept();
        dept.setCloseDate(Util.getDate("01/01/1000"));
        final Set<ConstraintViolation<Dept>> violations = validator.validate(dept);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

    @Test
    public void TestEntityId() {
        System.out.println("== Test @EntityId ==");
        final Dept dept = TestData.getDept();
        Set<ConstraintViolation<Dept>> violations = validator.validate(dept);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        dept.setDept_id("D001");
        violations = validator.validate(dept);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

}
