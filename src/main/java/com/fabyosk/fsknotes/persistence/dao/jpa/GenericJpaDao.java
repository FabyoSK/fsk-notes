package com.fabyosk.fsknotes.persistence.dao.jpa;


import com.fabyosk.fsknotes.model.Model;
import com.fabyosk.fsknotes.persistence.TransactionException;
import com.fabyosk.fsknotes.persistence.dao.Dao;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * A generic jpa data access object to be used as a base for concrete jpa service implementations
 *
 * @param <T> the model type
 * @see Dao
 */
public abstract class GenericJpaDao<T extends Model> implements Dao<T> {

    protected Class<T> modelType;

    @PersistenceContext
    protected EntityManager em;

    /**
     * @param modelType the model type
     */
    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    /**
     * @see Dao#findAll()
     */
    @Override
    public List<T> findAll() {

        try {


            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
            Root<T> root = criteriaQuery.from(modelType);
            return em.createQuery(criteriaQuery).getResultList();


        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    /**
     * @see Dao#findById(Integer)
     */
    @Override
    public T findById(Integer id) {

        try {

            return em.find(modelType, id);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    /**
     * @see Dao#saveOrUpdate(Model)
     */
    @Override
    public T saveOrUpdate(T modelObject) {

        try {

            return em.merge(modelObject);

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    /**
     * @see Dao#delete(Integer)
     */
    @Override
    public void delete(Integer id) {

        try {

            em.remove(em.find(modelType, id));

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
