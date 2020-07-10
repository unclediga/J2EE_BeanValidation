package ru.unclediga.cascade;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Date;

public abstract class CreditCard {

    @AssertTrue
    public static boolean checkTestCode(@NotNull String code) {
        return code.startsWith("#TC#");
    }

    public abstract void setCardNumber(String cardNumber);

    public abstract CreditCard getCopy();

    public abstract void setExpirationDate(Date expirationDate);

    public abstract void setTestCode(String testCode);
}
