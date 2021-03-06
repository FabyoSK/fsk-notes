package com.fabyosk.fsknotes.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

/**
 * The Note entity
 */
@Entity
public class Note implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String content;

    /**
     * Stores the creation time of the Note
     */
    @CreationTimestamp
    private Date creationTime;

    @ManyToOne
    private User user;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }


    /**
     * GETTERS AND SETTERS AREA
     */


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationTime=" + creationTime +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(user, note.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}
