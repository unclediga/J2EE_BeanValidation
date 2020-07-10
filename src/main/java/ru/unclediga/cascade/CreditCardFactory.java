package ru.unclediga.cascade;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class CreditCardFactory {
    public CreditCard create(@NotNull String cardNumber, @NotNull @Future Date expirationDate, @NotNull @Size(min = 5) String testCode) {
        return new CreditCardField();
    }

    public CreditCard create(@NotNull @Valid CreditCard card) {
        return card.getCopy();
    }
}
