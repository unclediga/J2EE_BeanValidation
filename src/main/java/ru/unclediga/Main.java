package ru.unclediga;

import ru.unclediga.util.TestBooks;
import ru.unclediga.util.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Book book = TestBooks.getAll().get(0);
        simpleValidation(book);
        book.setIsbn("123");
        simpleValidation(book);
        book = TestBooks.getAll().get(1);
        book.setPublisher("A");
        simpleValidation(book);
    }

    private static void simpleValidation(Book book) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        final Validator validator = validatorFactory.getValidator();
        final Set<ConstraintViolation<Book>> violations = validator.validate(book);
        System.out.println("Simple validation");
        if (violations.isEmpty()) {
            System.out.println("No validation errors");
        } else {
            for (ConstraintViolation<Book> violation : violations) {
                Util.printViolation(violation);
            }
        }
        validatorFactory.close();
    }
}
