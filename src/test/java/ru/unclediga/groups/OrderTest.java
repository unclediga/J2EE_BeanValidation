package ru.unclediga.groups;

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

public class OrderTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() throws Exception {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        validatorFactory.close();
    }

    @Test
    public void allGood() {
        final Order order = TestData.getOrder();
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        Util.printViolations(violations);
        assertEquals(0, violations.size());
    }

    @Test
    public void setId() {
        final Order order = TestData.getOrder();
        order.setId(null);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        Util.printViolations(violations);
        assertEquals(1, violations.size());

        violations = validator.validate(order, SignedGroup.class, OperationGroup.class);
        Util.printViolations(violations);
        assertEquals(0, violations.size());
    }

    @Test
    public void setDatePrepare() {
        System.out.println("setDatePrepare()==============");
        final Order order = TestData.getOrder();
        order.setDatePrepare(null);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        Util.printViolations(violations);
        assertEquals(1, violations.size());

        violations = validator.validate(order, SignedGroup.class);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        violations = validator.validate(order, OperationGroup.class);
        Util.printViolations(violations);
        assertEquals(0, violations.size());
    }

    @Test
    public void setDateSigned() {
        System.out.println("setDateSigned()==============");
        final Order order = TestData.getOrder();
        order.setDateSigned(null);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        violations = validator.validate(order, SignedGroup.class);
        Util.printViolations(violations);
        assertEquals(1, violations.size());

        violations = validator.validate(order, OperationGroup.class);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

    @Test
    public void setDateOperation() {
        System.out.println("setDateOperation()==============");
        final Order order = TestData.getOrder();
        order.setDateOperation(null);
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        violations = validator.validate(order, SignedGroup.class);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        violations = validator.validate(order, OperationGroup.class);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }
}