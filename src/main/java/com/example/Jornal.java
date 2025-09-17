package com.example;

import java.time.LocalDate;

public class Jornal extends Document {
    private String chiefEditor;

    public Jornal(String title, String author, LocalDate datePublish, String chiefEditor) {
        super(title, author, datePublish);
        this.chiefEditor = chiefEditor;
    }

    public String getChiefEditor() {
        return chiefEditor;
    }

    public void setChiefEditor(String chiefEditor) {
        this.chiefEditor = chiefEditor;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Chief Editor: "+ chiefEditor);
    }

}
