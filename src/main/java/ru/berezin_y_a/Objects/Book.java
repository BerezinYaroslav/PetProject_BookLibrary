package ru.berezin_y_a.Objects;

public class Book {
    public final String name;
    public final String author;
    public final String url;

    public Book(String name, String author, String url) {
        this.name = name;
        this.author = author;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
