package ru.unclediga.xml;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Book {
    @Pattern(regexp = "^(97([89]))-?\\d{9}(\\d|X)$")
    private String isbn;
    private String author;
    private String title;
    @Min(2)
    private Float price;

    public Book(String isbn, String author, String title, Float price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
