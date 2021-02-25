package com.fabyosk.fsknotes.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * The User entity
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;


    @OneToMany(targetEntity = Note.class)
    private List<Note> notes;

    /**
     * Create a new instante of noteMap and set the name
     *
     * @param name
     */
    public User(String name) {
        this.name = name;
        notes = new LinkedList<>();
    }

    public User() {
    }

    /**
     * Adds a new note in te map
     *
     * @param note
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Remove the given note
     *
     * @param id
     */
    public void removeNote(int id) {
        notes.remove(id);
    }


    /**
     * Gets the user Id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set th user id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the user
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes=" + notes +
                '}';
    }
}
