package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LibraryService {

    /*
    Class service that will handle with many book services.
    this is only to pratice the lambda expressions
    * */


    //Search books by author
    public static List<Book> findBooksByAuthor(ArrayList<Book> books, String author) {
        return books.stream()
                .filter(book -> book.getAuthor().contains(author))
                .collect(Collectors.toList());
    }

    // count  how many avaliable books exist
    public static long countAvailableBooks(ArrayList<Book> books) {
        return books.stream()
                .filter(Book::isAvailable)
                .count();
    }

    // lend books by
    public static List<Book> lendBookById(List<Book> books, Integer id) {
        return books.stream()
                .map(book -> {
                    //find a book by it's ID. If exist, create a new instance to respect the immutability rule on stream.
                    if (Objects.equals(book.getId(), id) && book.isAvailable()) { //if a match between Id's occurs and the book is not borrowed.
                        return new Book(
                                book.getId(),
                                book.getTitle(),
                                book.getAuthor(),
                                book.getDatePublish(),
                                book.getEdition(),
                                false
                        );
                    } else {
                        return book;
                    }
                })
                .collect(Collectors.toList());
    }

    // return a book by ID
    public static List<Book> returnBookById(List<Book> books, Integer id) {
        return books.stream()
                .map(book -> {
                    //find a book by it's ID. If exist, create a new instance to respect the immutability rule on stream.
                    if (Objects.equals(book.getId(), id) && !book.isAvailable()) {//if a match between Id's occurs and the book is borrowed.
                        return new Book(
                                book.getId(),
                                book.getTitle(),
                                book.getAuthor(),
                                book.getDatePublish(),
                                book.getEdition(),
                                true // book returned
                        );
                    } else {
                        return book;
                    }
                })
                .collect(Collectors.toList());
    }
}