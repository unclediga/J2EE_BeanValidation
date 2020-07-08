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

public class EmpTest {
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
        System.out.println("== Test @ChronoOrder @ChronoOrderEmp ==");
        final Emp emp = TestData.getEmps().get(0);
        emp.setFireDate(Util.getDate("01/01/1000"));
        final Set<ConstraintViolation<Emp>> violations = validator.validate(emp);
        Util.printViolations(violations);
        assertEquals(2, violations.size());
    }

    @Test
    public void TestEntityId() {
        System.out.println("== Test @EntityId ==");
        final Emp emp = TestData.getEmps().get(0);
        Set<ConstraintViolation<Emp>> violations = validator.validate(emp);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        emp.setEmp_id("IV001");
        violations = validator.validate(emp);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

    @Test
    public void TestNotEmptyAndBlank() {
        System.out.println("== Test @NotEmptyAndBlank ==");
        final Emp emp = TestData.getEmps().get(0);

        emp.setName(null);
        Set<ConstraintViolation<Emp>> violations = validator.validate(emp);
        Util.printViolations(violations);
        assertEquals(1, violations.size());

        emp.setName("");
        violations = validator.validate(emp);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }
}
