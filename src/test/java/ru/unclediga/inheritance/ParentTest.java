package ru.unclediga.inheritance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ParentTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void tearDown() {
        validatorFactory.close();
    }

    @Test
    public void parent() {
        Parent parent = new Parent("Parent name");
        Set<ConstraintViolation<Parent>> violations = validator.validate(parent);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        parent.setName("A");
        violations = validator.validate(parent);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

    @Test(expected = javax.validation.ConstraintDeclarationException.class)
    public void childOne() {
        /*javax.validation.ConstraintDeclarationException: HV000151:
        A method overriding another method must not alter the parameter constraint configuration,
        but method public java.lang.String ru.unclediga.inheritance.ChildOne.getName(java.lang.Integer)
        changes the configuration of public java.lang.String ru.unclediga.inheritance.Parent.getName(java.lang.Integer).*/
        Parent childOne = new ChildOne("ChildOne name", 16);
        Set<ConstraintViolation<Parent>> violations = validator.validate(childOne);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

//        childOne = new ChildOne("ChildOne name", 15);
//        violations = validator.validate(childOne);
//        Util.printViolations(violations);
//        assertEquals(1, violations.size());
//
//        childOne = new ChildOne("N", 15);
//        violations = validator.validate(childOne);
//        Util.printViolations(violations);
//        assertEquals(2, violations.size());

    }


    @Test(expected = javax.validation.ConstraintDeclarationException.class)
    public void getNameChildOne() throws NoSuchMethodException {
        /*javax.validation.ConstraintDeclarationException: HV000151:
        A method overriding another method must not alter the parameter constraint configuration,
        but method public java.lang.String ru.unclediga.inheritance.ChildOne.getName(java.lang.Integer)
        changes the configuration of public java.lang.String ru.unclediga.inheritance.Parent.getName(java.lang.Integer).*/
        Parent childOne = new ChildOne("ChildOne name", 16);
        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<Parent>> violations = executableValidator.validateParameters(childOne,
                ChildOne.class.getMethod("getName", Integer.class),
                new Object[]{35});
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

    @Test
    public void childTwo() {
        Parent childTwo = new ChildTwo("ChildTwo Parent's name", "ChildTwo name");
        Set<ConstraintViolation<Parent>> violations = validator.validate(childTwo);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        childTwo = new ChildTwo("N", "ChildTwo name");
        violations = validator.validate(childTwo);
        Util.printViolations(violations);
        assertEquals(1, violations.size());

        childTwo = new ChildTwo("N", "ChildTwo");
        violations = validator.validate(childTwo);
        Util.printViolations(violations);
        assertEquals(2, violations.size());
    }
}