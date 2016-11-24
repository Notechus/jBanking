package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.EntityDAO;
import com.sip.jbanking.domain.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * @author Notechus.
 */
public abstract class BaseEntityDAO<T extends Entity<ID>, ID extends Serializable> implements EntityDAO<T, ID> {

    private static final Logger log = LoggerFactory.getLogger(BaseEntityDAO.class);

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> persistentClass;

    public BaseEntityDAO() {
        this.persistentClass = null;
    }

    public BaseEntityDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public void create(T instance) {
        try {
            entityManager.persist(instance);
        } catch (Exception e) {
            log.error("error trying to create ", e);
            throw e;
        }
    }

    @Override
    public void createList(List<T> instances) {
        for (T entity : instances) {
            create(entity);
        }
    }

    @Override
    public T update(T instance) {
        T res = null;
        try {
            res = entityManager.merge(instance);
        } catch (Exception e) {
            log.error("error trying to update " + e);
        }
        return res;
    }

    @Override
    public T createOrUpdate(T instance) {
        if (instance.getId() != null) {
            return entityManager.merge(instance);
        }
        entityManager.persist(instance);
        return instance;
    }

    @Override
    public void delete(T instance) {
        try {
            T ins = entityManager.merge(instance);
            entityManager.remove(ins);
        } catch (Exception e) {
            log.error("error trying to delete " + e);
        }
    }

    @Override
    public T findById(ID id) {
        T res = null;
        try {
            res = entityManager.find(persistentClass, id);
        } catch (Exception e) {
            log.error("error trying to find " + persistentClass.getSimpleName());
            throw e;
        }
        return res;
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t", persistentClass).getResultList();
    }

    @Override
    public long count() {
        Query query = entityManager.createQuery("select count(*) as total from " + persistentClass.getSimpleName());
        return (Long) query.getSingleResult();
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public void refresh(T instance) {
        entityManager.refresh(instance);
    }
}
