package ru.unclediga.cascade;

import ru.unclediga.Util;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static CreditCardConst getCardTypeConst() {
        return new CreditCardConst("5552-0001",
                Util.getDate("01/01/2025"),
                "#TC#1");
    }

    public static CreditCardField getCardTypeField() {
        return new CreditCardField("4447-0002",
                Util.getDate("02/01/2025"),
                "#TC#2");
    }

    public static List<CreditCard> getCards() {
        return Arrays.asList(getCardTypeConst(), getCardTypeField());
    }
}
