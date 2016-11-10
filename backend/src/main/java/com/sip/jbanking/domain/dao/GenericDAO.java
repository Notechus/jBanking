package com.sip.jbanking.domain.dao;

import com.sip.jbanking.domain.entity.Entity;

import java.util.List;

/**
 * @author notechus.
 */
public interface GenericDAO {

    public void create(Entity<?> entity);

    public <T extends Entity<?>> void createList(List<T> entity);

    public <T extends Entity<?>> T update(T entity);

    public <T extends Entity<?>> void delete(T entity);

    public <T extends Entity<ID>, ID> T findById(ID id, Class<T> entityClass);

    public <T extends Entity<ID>, ID> T getReference(ID id, Class<T> entityClass);

    public <T extends Entity<?>> long count(Class<T> entityClass);

    public <T extends Entity<ID>, ID> List<T> findAll(Class<T> entityClass);

    public void flush();

    <T extends Entity<?>> void refresh(T entity);

    public <T extends Entity<?>> T createOrUpdate(T entity);
}
