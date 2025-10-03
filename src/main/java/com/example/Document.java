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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null|| id<0 ){
            throw new IllegalArgumentException("ID is mandatory");
        }
        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title is mandatory");
            }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author is mandatory");
        }
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
