package com.example;

import Interfaces.Availability;

import java.time.LocalDate;

public class Book extends Document implements Availability {

    private String edition;
    private boolean available = true;

    public Book() {
    }


    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        if (edition == null || edition.isEmpty()) {
            throw new IllegalArgumentException("Edition is mandatory");
        }

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
