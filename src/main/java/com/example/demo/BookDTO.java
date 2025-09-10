package com.example.demo;

public class BookDTO {

    private String title;

    public BookDTO() {}

    public BookDTO(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
