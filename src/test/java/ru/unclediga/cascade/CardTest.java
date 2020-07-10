package ru.unclediga.cascade;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.unclediga.Util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CardTest {

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
    public void createNew() {
        CreditCard cardTypeConst = TestData.getCardTypeConst();
        CreditCard cardTypeField = TestData.getCardTypeField();
        Set<ConstraintViolation<CreditCard>> violations;

        violations = validator.validate(cardTypeConst);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        violations = validator.validate(cardTypeField);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        cardTypeConst.setCardNumber(null);
        cardTypeField.setCardNumber(null);

        violations = validator.validate(cardTypeConst);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        violations = validator.validate(cardTypeField);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

    @Test
    public void createFactory() throws NoSuchMethodException {

        CreditCardFactory creditCardFactory = new CreditCardFactory();
        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<CreditCardFactory>> violations;

        ////////////////////////////////////////////////////////
        // create(@Valid Card)
        ////////////////////////////////////////////////////////
        System.out.println(" = = = Validate the method create(@Valid CreditCard card) with CardField");

        CreditCard card = TestData.getCardTypeField().getCopy();

        Method method = CreditCardFactory.class.getMethod("create", CreditCard.class);
        Object[] parameterValues = new Object[]{card};
        violations = executableValidator.validateParameters(creditCardFactory, method, parameterValues);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        // no valid card
        card.setCardNumber(null);
        card.setExpirationDate(null);
        card.setTestCode("#TC#");

        violations = executableValidator.validateParameters(creditCardFactory, method, parameterValues);
        Util.printViolations(violations);
        assertEquals(3, violations.size());

        /////////////////////////////////////////
        System.out.println(" = = = Validate the method create(@Valid CreditCard card) with CardConst");
        card = TestData.getCardTypeConst().getCopy();
        parameterValues = new Object[]{card};
        violations = executableValidator.validateParameters(creditCardFactory, method, parameterValues);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        // no valid card
        card.setCardNumber(null);
        card.setExpirationDate(null);
        card.setTestCode("#TC#");

        violations = executableValidator.validateParameters(creditCardFactory, method, parameterValues);
        Util.printViolations(violations);
        assertEquals(0, violations.size());


        ////////////////////////////////////////////////////////
        // create(@NotNull String cardNumber, @NotNull @Future Date expirationDate, @NotNull @Size(min = 5) String testCode)
        ////////////////////////////////////////////////////////
        System.out.println(" = = = Validate the method create(@NotNull String cardNumber, @NotNull @Future Date ...");
        method = CreditCardFactory.class.getMethod("create", String.class, Date.class, String.class);
        parameterValues = new Object[]{"5551", Util.getDate("01/05/2025"), "#TC#1"};
        violations = executableValidator.validateParameters(creditCardFactory, method, parameterValues);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        parameterValues = new Object[]{null, Util.getDate("07/11/1917"), "#TC#"};
        violations = executableValidator.validateParameters(creditCardFactory, method, parameterValues);
        Util.printViolations(violations);
        assertEquals(3, violations.size());
    }

    @Test
    public void constructorViolation() throws NoSuchMethodException {
        Object[] constructorParams = new Object[]{null, Util.getDate("07/11/1917"), "AA"};
        ExecutableValidator executableValidator = validator.forExecutables();

        System.out.println(" = = = Validate constructor  with CardConst");
        Constructor<CreditCardConst> cardConstConstructor = CreditCardConst.class.getConstructor(String.class, Date.class, String.class);
        Set<ConstraintViolation<CreditCardConst>> violations
                = executableValidator.validateConstructorParameters(cardConstConstructor, constructorParams);
        Util.printViolations(violations);
        assertEquals(3, violations.size());

        constructorParams = new Object[]{"5555-1", Util.getDate("01/11/2025"), "#TC#3"};
        executableValidator = validator.forExecutables();
        violations = executableValidator.validateConstructorParameters(cardConstConstructor, constructorParams);
        Util.printViolations(violations);
        assertEquals(0, violations.size());

        //////////////////////////////////////////////////////////
        System.out.println(" = = = Validate constructor  with CardField");
        Constructor<CreditCardField> cardFieldConstructor = CreditCardField.class.getConstructor(String.class, Date.class, String.class);
        Set<ConstraintViolation<CreditCardField>> violations2
                = executableValidator.validateConstructorParameters(cardFieldConstructor, constructorParams);
        Util.printViolations(violations2);
        assertEquals(0, violations2.size());

        constructorParams = new Object[]{"5555-1", Util.getDate("01/11/2025"), "#TC#3"};
        executableValidator = validator.forExecutables();
        violations2 = executableValidator.validateConstructorParameters(cardFieldConstructor, constructorParams);
        Util.printViolations(violations2);
        assertEquals(0, violations2.size());
    }

    @Test
    public void validateProperties() {
        System.out.println(" = = = Validate property 'cardNumber'");
        CreditCard card = TestData.getCardTypeField().getCopy();
        Set<ConstraintViolation<CreditCard>> violations = validator.validateProperty(card, "cardNumber");
        Util.printViolations(violations);
        assertEquals(0, violations.size());
        card.setTestCode("#TC#");
        violations = validator.validateProperty(card, "cardNumber");
        Util.printViolations(violations);
        assertEquals(0, violations.size());
        card.setCardNumber(null);
        violations = validator.validateProperty(card, "cardNumber");
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

    @Test
    public void validateValues() {
        System.out.println(" = = = Validate value 'expirationDate'");
        Set<ConstraintViolation<CreditCardField>> violations =
                validator.validateValue(CreditCardField.class, "expirationDate", Util.getDate("01/05/2025"));
        Util.printViolations(violations);
        assertEquals(0, violations.size());
        violations =
                validator.validateValue(CreditCardField.class, "expirationDate", Util.getDate("07/11/1917"));
        Util.printViolations(violations);
        assertEquals(1, violations.size());
        violations =
                validator.validateValue(CreditCardField.class, "expirationDate", null);
        Util.printViolations(violations);
        assertEquals(1, violations.size());
    }

}
