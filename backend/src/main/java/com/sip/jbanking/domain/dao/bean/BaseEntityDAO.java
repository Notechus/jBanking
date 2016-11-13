package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.EntityDAO;
import com.sip.jbanking.domain.dao.GenericDAO;
import com.sip.jbanking.domain.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    private GenericDAO genericDAO;

    public BaseEntityDAO() {
        //TODO: ...
        this.persistentClass = null;
        this.genericDAO = new GenericDAOBean(entityManager);
    }

    public BaseEntityDAO(EntityManager entityManager, Class<T> persistentClass) {
        this.entityManager = entityManager;
        this.persistentClass = persistentClass;
        this.genericDAO = new GenericDAOBean(entityManager);
    }

    public BaseEntityDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.genericDAO = new GenericDAOBean(entityManager);
    }

    @Override
    public void create(T instance) {
        genericDAO.create(instance);
    }

    @Override
    public void createList(List<T> instances) {
        genericDAO.createList(instances);
    }

    @Override
    public T update(T instance) {
        return genericDAO.update(instance);
    }

    @Override
    public T createOrUpdate(T instance) {
        return genericDAO.createOrUpdate(instance);
    }

    @Override
    public void delete(T instance) {
        genericDAO.delete(instance);
    }

    @Override
    public T findById(ID id) {
        return genericDAO.findById(id, persistentClass);
    }

    @Override
    public List<T> findAll() {
        return genericDAO.findAll(persistentClass);
    }

    @Override
    public T getReference(ID id) {
        return genericDAO.getReference(id, persistentClass);
    }

    @Override
    public long count() {
        return genericDAO.count(persistentClass);
    }

    @Override
    public void flush() {
        genericDAO.flush();
    }

    @Override
    public void refresh(T instance) {
        genericDAO.refresh(instance);
    }
}
