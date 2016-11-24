package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.LocationDAO;
import com.sip.jbanking.domain.entity.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author notechus.
 */
@Repository("LocationDAO")
public class LocationDAOBean extends BaseEntityDAO<Location, Long> implements LocationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public LocationDAOBean() {
        super(Location.class);
    }
}
