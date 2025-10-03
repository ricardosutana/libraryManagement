package com.example;

import java.time.LocalDate;

public class Jornal extends Document {
    private String chiefEditor;

    public String getChiefEditor() {
        return chiefEditor;
    }

    public void setChiefEditor(String chiefEditor) {
        if (chiefEditor == null || chiefEditor.isEmpty()) {
            throw new IllegalArgumentException("Editor is mandatory");
        }
        this.chiefEditor = chiefEditor;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Chief Editor: "+ chiefEditor);
    }

}
