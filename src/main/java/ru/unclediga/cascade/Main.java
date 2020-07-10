package ru.unclediga.cascade;

import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CreditCardFactory>> violations;
        ExecutableValidator executableValidator = validator.forExecutables();

        System.out.println(" = = = Validate the method create(@Valid CreditCard card) with Bad CardField");
        CreditCardFactory cardFactory = new CreditCardFactory();
        Method method = CreditCardFactory.class.getMethod("create", CreditCard.class);
        Object[] parameterValues = new Object[]{new CreditCardField(null, Util.getDate("01/05/2055"), "#TC#1")};
        violations = executableValidator.validateParameters(cardFactory, method, parameterValues);
        Util.printViolations(violations);

        System.out.println(" = = = Validate the method create(@Valid CreditCard card) with Bad CardConst");
        cardFactory = new CreditCardFactory();
        method = CreditCardFactory.class.getMethod("create", CreditCard.class);
        parameterValues = new Object[]{new CreditCardConst(null, Util.getDate("01/05/2055"), "#TC#1")};
        violations = executableValidator.validateParameters(cardFactory, method, parameterValues);
        Util.printViolations(violations);

        System.out.println("Validate the method create(@NotNull String cardNumber, @NotNull @Future Date date, @NotNull @Size(min=5) String code)");
        method = CreditCardFactory.class.getMethod("create", String.class, Date.class, String.class);
        parameterValues = new Object[]{null, Util.getDate("01/05/2025"), "#TC#"};
        violations = executableValidator.validateParameters(cardFactory, method, parameterValues);
        Util.printViolations(violations);

        validatorFactory.close();
    }
}

