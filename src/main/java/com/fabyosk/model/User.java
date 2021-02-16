package com.fabyosk.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The User entity
 */
public class User {
    private int id;
    private String name;
    private Map<Integer, Note> noteMap;

    /**
     * Create a new instante of noteMap and set the name
     *
     * @param name
     */
    public User(String name) {
        this.name = name;
        noteMap = new HashMap();
    }


    /**
     * Adds a new note in te map
     *
     * @param note
     */
    public void addNote(Note note) {
        noteMap.put(0, note);
    }

    /**
     * Remove the given note
     *
     * @param id
     */
    public void removeNote(int id) {
        noteMap.remove(id);
    }


    /**
     * Gets the user Id
     *
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Get the name of the user
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Set th user id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
