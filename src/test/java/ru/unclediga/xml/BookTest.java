package ru.unclediga.xml;

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
        Book book = new Book("978-0007148387", "Leo Tolstoy", "War and Peace", 28.73f);
        final Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Util.printViolations(violations);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void violationsAll() {
        Book book = new Book(null, null, null, 0.0f);
        final Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Util.printViolations(violations);
        Assert.assertEquals(4, violations.size());
    }

    @Test
    public void violationIsbn() {
        Book book = new Book(null, "Leo Tolstoy", "War and Peace", 28.73f);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Assert.assertEquals(1, violations.size());

        book = new Book("A", "Leo Tolstoy", "War and Peace", 28.73f);
        violations = validator.validate(book);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void violationAuthor() {
        Book book = new Book("978-0007148387", null, "War and Peace", 28.73f);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Assert.assertEquals(1, violations.size());

        book = new Book("978-0007148387", "Leo", "War and Peace", 28.73f);
        violations = validator.validate(book);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void violationTitle() {
        Book book = new Book("978-0007148387", "Leo Tolstoy", null, 28.73f);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void violationsPrice() {
        Book book = new Book("978-0007148387", "Leo Tolstoy", "War and Peace", 1.9f);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Assert.assertEquals(0, violations.size());

        book = new Book("978-0007148387", "Leo Tolstoy", "War and Peace", 0.99f);
        violations = validator.validate(book);
        Assert.assertEquals(1, violations.size());
    }
}
