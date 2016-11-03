package com.sip.jbanking.domain.entity;

import javax.persistence.PrePersist;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * @author notechus.
 */
public abstract class BaseEntity<T> implements Entity<T> {

    protected Date creationTime;

    protected Date modificationTime;

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public abstract boolean equals(Object o);

    public abstract int hashCode();

    @PrePersist
    protected void initCreationDate() {
        if (creationTime == null) {
            setCreationTime(new Timestamp(Calendar.getInstance().getTime().getTime()));
        }
    }

    protected void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

}
