package ru.unclediga.util;

import ru.unclediga.Book;

import java.util.Arrays;
import java.util.List;

public class TestBooks {
    public static List<Book> getAll() {

        return Arrays.asList(

                new Book("978-0007148387",
                        "Leo Tolstoy",
                        "War and Peace",
                        "Harper Perennial",
                        Util.getDate("02/04/2007"),
                        1024,
                        28.73f),

                new Book("978-0375702242",
                        "Fyodor Dostoevsky",
                        "The Idiot",
                        "Vintage",
                        Util.getDate("08/07/2003"),
                        656,
                        11.79f));
    }
}
