package ru.berezin_y_a.Managers;

import ru.berezin_y_a.Objects.Book;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface Manager {
    void printMenu();

    void printAllBooks(List<Book> library);

    String findBookByName(String name, List<Book> library);

    String findBookByAuthor(String author, List<Book> library);

    Book addBookInLibrary(Scanner scanner);

    void addSomeSampleBooks(List<Book> list);

    String giveFeedback(Scanner scanner);

    void downloadBook(Book book) throws IOException;

    void printFeedbacks(List<String> list);
}
