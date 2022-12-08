package ru.berezin_y_a.Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Author {
    public final String name;
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books.toArray()) +
                '}';
    }
}
