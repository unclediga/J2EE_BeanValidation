package ru.unclediga;

import javax.validation.constraints.*;
import java.util.Date;

public class Book {
    @NotNull
    @Pattern(regexp = "^(97([89]))-?\\d{9}(\\d|X)$")
    private String isbn;
    @NotNull
    private String author;
    @NotNull
    private String title;
    @Size(min = 4, max = 20)
    private String publisher;
    @Past
    private Date datePub;
    private Integer pageCount;
    @NotNull
    @Min(2)
    private Float price;

    public Book(String isbn, String author, String title, String publisher, Date datePub, Integer pageCount, Float price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.datePub = datePub;
        this.pageCount = pageCount;
        this.price = price;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Float getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Date getDatePub() {
        return datePub;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", datePub=" + datePub +
                ", pageCount=" + pageCount +
                ", price=" + price +
                '}';
    }
}
