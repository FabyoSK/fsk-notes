package com.fabyosk.fsknotes.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The User entity
 */
@Entity
@Table(name = "users")
public class User implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String name;
    private String password;

    /**
     * Stores the creation time of the User
     */
    @CreationTimestamp
    private Date creationTime;

    /**
     * A User has Many notes
     */
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            // use User foreign key on Notes table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user",
            fetch = FetchType.EAGER
    )
    private List<Note> notes = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    /**
     * Auxiliary method to help Hibernate
     *
     * @see Note
     */
    public void addNote(Note note) {
        notes.add(note);
        note.setUser(this);
    }


    public void removeNote(Note note) {
        notes.remove(note);
        note.setUser(null);
    }


    /**
     * GETTERS AND SETTERS AREA
     */

    @Override
    public Integer getId() {
        return id;
    }


    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes=" + notes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
