package ru.berezin_y_a;

import ru.berezin_y_a.Managers.LibraryManager;
import ru.berezin_y_a.Managers.Manager;
import ru.berezin_y_a.Objects.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final List<Book> library = new ArrayList<>();
        final List<String> feedbacks = new LinkedList<>();

        final Scanner scanner = new Scanner(System.in);
        final Manager manager = new LibraryManager();
        manager.addSomeSampleBooks(library);

        while (true) {
            manager.printMenu();
            byte command = scanner.nextByte();
            scanner.nextLine();

            switch (command) {
                case 1: {
                    manager.printAllBooks(library);
                    break;
                }

                case 2: {
                    System.out.print("Введите название: ");
                    String name = scanner.nextLine();
                    System.out.println(manager.findBookByName(name, library));
                    manager.downloadBook(library.get(0));
                    break;
                }

                case 3: {
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.println(manager.findBookByAuthor(author, library));
                    break;
                }

                case 4: {
                    library.add(manager.addBookInLibrary(scanner));
                    break;
                }

                case 5: {
                    feedbacks.add(manager.giveFeedback(scanner));
                    break;
                }

                case 6: {
                    manager.printFeedbacks(feedbacks);
                }

                case 0: {
                    System.out.println("До новых встреч!");
                    return;
                }

                default: {
                    System.out.println("Такой команды нет, попробуйте еще раз");
                }
            }
        }
    }
}
