package ru.berezin_y_a.Managers;

import ru.berezin_y_a.Objects.Book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.Scanner;

public class LibraryManager implements Manager {
    @Override
    public void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Вывести список всех доступных книг");
        System.out.println("2 - Найти книгу по названию");
        System.out.println("3 - Найти книгу по автору");
        System.out.println("4 - Добавить книгу в библиотеку");
        System.out.println("5 - Оставить замечания или рекомендации разработчикам");
        System.out.println("6 - Просмотреть отзывы");
        System.out.println("0 - Выйти");
    }

    @Override
    public void printAllBooks(List<Book> library) {
        for (Book book : library) {
            System.out.println(book);
        }
    }

    @Override
    public String findBookByName(String name, List<Book> library) {
        for (Book book : library) {
            if (book.name.equals(name)) {
                return "Вот, что нашлось: " + book.url;
            }
        }

        return "Нет книги с таким названием";
    }

    @Override
    public String findBookByAuthor(String author, List<Book> library) {
        for (Book book : library) {
            if (book.author.equals(author)) {
                return "Вот, что нашлось: " + book.url;
            }
        }

        return "Книги такого автора нет";
    }

    @Override
    public Book addBookInLibrary(Scanner scanner) {
        System.out.print("Введите название книги: ");
        String name = scanner.nextLine();

        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();

        System.out.print("Введите ссылку на книгу: ");
        String url = scanner.nextLine();

        return new Book(name, author, url);
    }

    @Override
    public String giveFeedback(Scanner scanner) {
        System.out.print("Введите ваше замечание или рекомендацию для разработчиков: ");
        return scanner.nextLine();
    }

    @Override
    public void downloadBook(Book book) throws IOException {
        URL url = new URL(book.url);
        String outputFileName = book.name;

        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    @Override
    public void addSomeSampleBooks(List<Book> list) {
        list.add(new Book("Программирование на Python. Том 1",
                "Лутц Марк",
                "https://avidreaders.ru/download/programmirovanie-na-python-tom-1.html?f=pdf")
        );
    }

    @Override
    public void printFeedbacks(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
}
