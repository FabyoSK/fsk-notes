package com.fabyosk.fsknotes.persistence.dao.jpa;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.persistence.dao.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * A JPA {@link UserDao} implementation
 */
@Repository
public class JpaUserDao extends GenericJpaDao<User> implements UserDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaUserDao() {
        super(User.class);
    }

    @Transactional
    public User findByName(String username){
        // 1 - get a CriteriaBuilder object from the EntityManager
        CriteriaBuilder builder = em.getCriteriaBuilder();

        // 2 - create a new CriteriaQuery instance for the Customer entity
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        // 3 - get the root of the query, from where all navigation starts
        Root<User> root = criteriaQuery.from(User.class);

        // 4 - specify the item that is to be returned in the query result
        criteriaQuery.select(root);

        // 5 - add query restrictions
        criteriaQuery.where(builder.equal(root.get("username"), username));

        // 6 - create and execute a query using the criteria
        return em.createQuery(criteriaQuery).getSingleResult();
    }
}
