package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.GenericDAO;
import com.sip.jbanking.domain.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author notechus.
 */
public class GenericDAOBean implements GenericDAO {

    private static final Logger log = LoggerFactory.getLogger(GenericDAOBean.class);

    protected EntityManager entityManager;

    public GenericDAOBean() {
    }

    public GenericDAOBean(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Entity<?> entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            log.error("error trying to create ", e);
            throw e;
        }
    }

    @Override
    public <T extends Entity<?>> void createList(List<T> entities) {
        for (Entity<?> entity : entities) {
            create(entity);
        }
    }

    @Override
    public <T extends Entity<?>> T update(T entity) {
        T res = null;
        try {
            res = entityManager.merge(entity);
        } catch (Exception e) {
            log.error("error trying to update " + e);
        }
        return res;
    }

    @Override
    public <T extends Entity<?>> void delete(T entity) {
        try {
            T instance = entityManager.merge(entity);
            entityManager.remove(instance);
        } catch (Exception e) {
            log.error("error trying to delete " + e);
        }
    }

    @Override
    public <T extends Entity<ID>, ID> T findById(ID id, Class<T> entityClass) {
        T res = null;
        try {
            res = entityManager.find(entityClass, id);
        } catch (Exception e) {
            log.error("error trying to find " + entityClass.getSimpleName());
            throw e;
        }
        return res;
    }

    @Override
    public <T extends Entity<ID>, ID> T getReference(ID id, Class<T> entityClass) {
        return entityManager.getReference(entityClass, id);
    }

    @Override
    public <T extends Entity<?>> long count(Class<T> entityClass) {
        Query query = entityManager.createQuery("select count(*) as total from " + entityClass.getSimpleName());
        return (Long) query.getSingleResult();
    }

    @Override
    public <T extends Entity<ID>, ID> List<T> findAll(Class<T> entityClass) {
        return entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t", entityClass).getResultList();
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public <T extends Entity<?>> void refresh(T entity) {
        entityManager.refresh(entity);
        entityManager.createQuery("", entity.getClass());
    }

    @Override
    public <T extends Entity<?>> T createOrUpdate(T entity) {
        if (entity.getId() != null) {
            return entityManager.merge(entity);
        }
        entityManager.persist(entity);
        return entity;
    }
}
