package com.example;

import Interfaces.Availability;

import java.time.LocalDate;

public class Book extends Document implements Availability {

    private String edition;
    private boolean available;

    public Book() {
    }

    public Book(String title, String author, LocalDate datePublish, String edition, boolean available) {
        super(title, author, datePublish);
        this.edition = edition;
        this.available = available;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }


    @Override
    public void showDetails(){
     super.showDetails();
     System.out.println("Edition: "+getEdition());
     System.out.println("Availability: "+(available ? "Not Available":"Available"));
    }


    @Override
    public void land() {
        if(!available){
            available = true;
            System.out.println("Book :"+getTitle()+" being landed");
        }
        else
            System.out.println("The book"+getTitle()+"is not avaliable");
    }

    @Override
    public void turnBack() {
        if (available){
            available = false;
            System.out.println("Book : "+getTitle()+"being returned, Thank you");
        }

    }

    @Override
    public boolean isAvailable() {
        return available;
    }
}
