package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LibraryService {

    private List<Book> books;

    public LibraryService(List<Book> books) {
        this.books = books;
    }

    public boolean lend(User user, Integer bookId) {
        //validation phase
        if (!user.getUserType().equals(User.UserType.BASIC)) {
            System.out.println("[PERMISSION ERROR - ] " + user.getName() + ": Only ordinary users may lend a book.");
            return false;
        }
        //search the book into the library bi its ID
        Book singleBook = findBookById(bookId);

        //if the book does not exist
        if (singleBook == null) {
            System.out.println(user.getName() +
                    ": Book ID " + bookId + " not found!");
            return false;
        }
        //sync the thread to avoid race conditions
        synchronized (singleBook) {
            if (!singleBook.isAvailable()) {
                System.out.println(user.getName() + ": Book " + singleBook.getTitle() + " is with another user. Wait your time!");
                return false;
            }

            singleBook.setAvailable(false); //change the availability of the book
            System.out.println(user.getName() + " book lended with success: " + singleBook.getTitle());
            return true;
        }
    }

    public boolean turnBack(User user, Integer bookId) {
        //validatiom phase
        if (!user.getUserType().equals(User.UserType.BASIC)) {
            System.out.println( user.getName() + ": Only ordinary users can return a book.");
            return false;
        }

        //search book into the library
        Book singleBook = findBookById(bookId);

        if (singleBook == null) {
            System.out.println(user.getName() + ": Book ID " + bookId + " not found");
            return false;
        }

        //sync the thread to avoid race conditions
        synchronized (singleBook) {
            if (singleBook.isAvailable()) {
                System.out.println( user.getName() + ": Book" + singleBook.getTitle() + "is available for you!");
                return false;
            }


            singleBook.setAvailable(true); //change the availability
            System.out.println(user.getName() +" returned the book: '" + singleBook.getTitle() + "' - Thank you!.");
            return true;
        }


    }

    public boolean add(User user, Book book) {
        //validation phase
        if (!user.getUserType().equals(User.UserType.ADMIN)) {
            System.out.println(user.getName() +": Permission denied - Only ADMINISTRATOR are able to add new book into the library.");
            return false;
        }


        if (findBookById(book.getId()) != null) {
            System.out.println(user.getName() +": Book ID " + book.getId() + " Already exist!");
            return false;
        }

        //sync the thread to avoid race conditions
        synchronized (books) {
            books.add(book);
            System.out.println(user.getName() + " add " + book.getTitle() + " into the book catalog. Total number of books : " + books.size() + " Books");
           return true;
        }
    }

    public boolean remove(User user, Integer bookId) {
        //validation phase
        if (!user.getUserType().equals(User.UserType.ADMIN)) {
            System.out.println( user.getName() + ": Permission denied - Only ADMINISTRATOR are able to add new book into the library.");
            return false;
        }

       //find book by ID
        Book singleBook = findBookById(bookId);

        if (singleBook == null) {
            System.out.println(user.getName() + ": Book ID " + bookId + " not found!");
            return false;
        }

        //is the book available?
        if (!singleBook.isAvailable()) {
            System.out.println(user.getName() + ": The book: " + singleBook.getTitle() + "is not available now. Wait the return to remove from catalog!");
            return false;
        }

        //sync the thread to avoid race conditions
        synchronized (books) {
            books.remove(singleBook);
            System.out.println(user.getName() +" removed the book " + singleBook.getTitle() +" from the library catolog. Total books: " + books.size() + " books");
            return true;
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        synchronized (books) {
            return books.stream()
                    .filter(book -> book.getAuthor().toLowerCase()
                            .contains(author.toLowerCase()))
                    .collect(Collectors.toList());
        }
    }

    public long countAvailableBooks() {
        synchronized (books) {
            return books.stream()
                    .filter(Book::isAvailable)
                    .count();
        }
    }

    public List<Book> listAllBooks() {
        //sync the thread to avoid race conditions
        synchronized (books) {
            return new ArrayList<>(books);
        }
    }

    private Book findBookById(Integer id) {
        //sync the thread to avoid race conditions
        synchronized (books) {
            for (Book book : books) {
                if (book.getId().equals(id)) {
                    return book;
                }
            }
        }
        return null;
    }

}