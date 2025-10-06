package Interfaces;

public interface Availability {
    //land a book
    void lend();

    //return a book
    void turnBack();

    //check if a given book is availliable
    boolean isAvailable();
}
