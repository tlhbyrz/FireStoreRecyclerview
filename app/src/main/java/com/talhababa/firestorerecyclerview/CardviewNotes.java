package com.talhababa.firestorerecyclerview;

import android.widget.TextView;

public class CardviewNotes {

    private String title;
    private String description;
    private int priority;

    public CardviewNotes(){
        // empty constructure needed
    }

    public CardviewNotes(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
