package com.sip.jbanking.domain.entity;

import java.io.Serializable;

/**
 * @author notechus.
 */
public interface Entity<T> extends Serializable {

    T getId();

    void setId(T id);

    @Override
    int hashCode();

    @Override
    boolean equals(Object o);
}
