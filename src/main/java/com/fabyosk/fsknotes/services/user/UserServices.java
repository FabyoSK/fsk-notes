package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import java.util.List;

public class UserServices {
    private User currentUser;
    private EntityManagerFactory emf;

    public UserServices() {
        emf = Persistence.createEntityManagerFactory("dev");
    }


    public List list() {
        return null;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void add(User user) {
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            em.persist(user);
            em.getTransaction().commit(); // close transaction

        } catch (RollbackException ex) {

            // something went wrong, make sure db is consistent
            em.getTransaction().rollback();

        } finally {
            if (em != null) {
                em.close();


            }
        }
    }

    public boolean authenticate(String username, String password) {
        return false;
    }


    public User findByName(String username) {
        return null;

    }

    public User findById(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(User.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> findAll() {
        return null;
    }

    public int count() {
        return 0;
    }


}
