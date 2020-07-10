package ru.unclediga.multiple;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static List<Address> getAdresses() {
        return Arrays.asList(
                new Address(AddressType.KLADR, "500010010020777"),
                new Address(AddressType.FIAS, "ABCD-FGHJ-0000-0777"),
                new Address(AddressType.KLADR, "50001001002088A"),
                new Address(AddressType.FIAS, "ABCD-FGHJ-0000-88")
        );
    }

}
