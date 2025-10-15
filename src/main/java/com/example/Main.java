package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import com.example.LibraryService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Book> bookArrayList = Collections.synchronizedList(new ArrayList<>());

        //book objects
        Book book1 = new Book();
        book1.setId(101);
        book1.setTitle("Clean Code");
        book1.setAuthor("Robert C. Martin");
        book1.setDatePublish(LocalDate.of(2008, 8, 1));
        book1.setEdition("1ª edição");

        //bookArrayList.add(book1);


        Book book2 = new Book();
        book2.setId(102);
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setDatePublish(LocalDate.of(2018, 1, 6));
        book2.setEdition("3ª edição");



        Book book3 = new Book();
        book3.setId(103);
        book3.setTitle("Java: The Complete Reference");
        book3.setAuthor("Herbert Schildt");
        book3.setDatePublish(LocalDate.of(2019, 4, 12));
        book3.setEdition("11ª edição");



        LibraryService libraryService = new LibraryService(bookArrayList);

        //use case 1: multiple admins adding books
        User admin1 = new User(1001, "Admin Carlos", User.UserType.ADMIN,
                libraryService, User.OperationType.ADD, book2);
        User admin2 = new User(1002, "Admin Ana", User.UserType.ADMIN,
                libraryService, User.OperationType.ADD, book3);
        User admin3 = new User(1003, "Admin Rick", User.UserType.ADMIN,
                libraryService, User.OperationType.ADD, book1);


        Thread t1 = new Thread(admin1);
        Thread t2 = new Thread(admin2);
        Thread t3 = new Thread(admin3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.start();

        Thread.sleep(500);

    }
}