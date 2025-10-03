package com.example;

import Interfaces.Availability;

public class Magazine extends Document implements Availability {
    private String periodicity;
    private boolean available = true;

    public Magazine(){
    }


    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        if (periodicity == null || periodicity.isEmpty()) {
            throw new IllegalArgumentException("Periodicity is mandatory");
        }
        this.periodicity = periodicity;
    }

    @Override
    public void showDetails(){
        super.showDetails();
        System.out.println("Periodicity: "+getPeriodicity());

    }
    @Override
    public void land() {
        if(!available){
            available = true;
            System.out.println("Magazine :"+getTitle()+" being landed");
        }
        else
            System.out.println("Magazine"+getTitle()+"is not avaliable");
    }

    @Override
    public void turnBack() {
        if (available){
            available = false;
            System.out.println("Magazine : "+getTitle()+"being returned, Thank you");
        }

    }

    @Override
    public boolean isAvailable() {
        return available;
    }
}
