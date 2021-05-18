package com.example.lesson1a2.models;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Task(String title) {
        this.title = title;
    }


}
