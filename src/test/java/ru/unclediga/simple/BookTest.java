package ru.unclediga.simple;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.unclediga.Util;
import ru.unclediga.simple.util.TestBooks;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BookTest {
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
        for (Book book : TestBooks.getAll()) {
            final Set<ConstraintViolation<Book>> violations = validator.validate(book);
            Util.printViolations(violations);
            Assert.assertEquals(0, violations.size());
        }
    }

    @Test
    public void violationIsbn() {
        for (Book book : TestBooks.getAll()) {
            book.setIsbn("123");
            final Set<ConstraintViolation<Book>> violations = validator.validate(book);
            Assert.assertEquals(1, violations.size());
        }
    }

    @Test
    public void violationsAll() {
        Book book = new Book();
        final Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Util.printViolations(violations);
        Assert.assertEquals(4, violations.size());
    }

    @Test
    public void violationsPrice() {
        for (Book book : TestBooks.getAll()) {
            book.setPrice(1.9f);
            final Set<ConstraintViolation<Book>> violations = validator.validate(book);
            Assert.assertEquals(1, violations.size());
        }
    }


}
