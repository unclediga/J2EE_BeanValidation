package ru.unclediga.message;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static Address getAddress() {
        return new Address("643",
                "143590", "50", "Истринский р-он", "Истра г",
                "Снегири п", "Льва Толстого ул", "10/1", "Б", 123);
    }

    public static List<Address> getAdresses() {
        return Arrays.asList(getAddress());
    }

}
