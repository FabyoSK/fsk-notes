package com.fabyosk.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private Map<Integer, Note> noteMap;

    public User(String name) {
        this.name = name;
        noteMap = new HashMap();
    }

    public void addNote(Note note){
        noteMap.put(0, note);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
