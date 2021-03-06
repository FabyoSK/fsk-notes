package com.fabyosk.fsknotes.persistence.dao.jpa;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.persistence.TransactionException;
import com.fabyosk.fsknotes.persistence.dao.UserDao;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * A JPA {@link UserDao} implementation
 */
public class JpaUserDao extends GenericJpaDao<User> implements UserDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaUserDao() {
        super(User.class);
    }


}
