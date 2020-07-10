package ru.unclediga.groups;

import ru.unclediga.Util;

import java.util.Arrays;

public class TestData {
    public static java.util.List<Order> getOrders() {
        return Arrays.asList(getOrder());
    }

    public static Order getOrder() {
        return new Order(1,
                "N1",
                Util.getDate("01/07/2020"),
                Util.getDate("15/07/2020"),
                Util.getDate("30/07/2020"));
    }
}
