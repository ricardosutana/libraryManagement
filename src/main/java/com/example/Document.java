package com.example;

import java.time.LocalDate;
import java.util.Objects;

public class Document {
    private Integer id;
    private String title;
    private String author;
    private LocalDate datePublish;

    public Document() {
    }

    public Document(String title, String author, LocalDate datePublish) {
        this.title = title;
        this.author = author;
        this.datePublish = datePublish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDate datePublish) {
        this.datePublish = datePublish;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Document documento)) return false;
        return Objects.equals(id, documento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", datePublish=" + datePublish +
                '}';
    }
    public void showDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publishment: " + datePublish);
    }

}
