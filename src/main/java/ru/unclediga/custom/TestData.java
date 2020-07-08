package ru.unclediga.custom;

import ru.unclediga.Util;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public static Dept getDept() {
        return new Dept("DD-001",
                "Dept #1",
                Util.getDate("01/01/2020"),
                Util.getDate("01/01/2021"),
                getEmps()

        );
    }

    public static List<Emp> getEmps() {
        return Arrays.asList(
                new Emp("IV-00001",
                        "Ivanov I.I.",
                        Util.getDate("11/01/2020"),
                        null,
                        "+74951235001"),
                new Emp("PE-00001",
                        "Petrov P.P.",
                        Util.getDate("12/01/2020"),
                        null,
                        "+74951235002"),
                new Emp("SI-00001",
                        "Sidorov S.S.",
                        Util.getDate("13/01/2020"),
                        Util.getDate("23/05/2020"),
                        "+74951235003")
        );
    }
}
