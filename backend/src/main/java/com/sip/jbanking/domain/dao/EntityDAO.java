package com.sip.jbanking.domain.dao;

import com.sip.jbanking.domain.entity.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author notechus.
 */
public interface EntityDAO<T extends Entity<ID>, ID extends Serializable> extends Serializable {

    public void create(T instance);

    public void createList(List<T> instances);

    public T update(T instance);

    public T createOrUpdate(T instance);

    public void delete(T instance);

    public T findById(ID id);

    public List<T> findAll();

    public T getReference(ID id);

    long count();

    void flush();

    void refresh(T instance);


}
