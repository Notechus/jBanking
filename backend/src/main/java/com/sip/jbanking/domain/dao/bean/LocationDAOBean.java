package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.entity.Location;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author notechus.
 */
@Repository("LocationDAO")
@EnableTransactionManagement
public class LocationDAOBean extends BaseEntityDAO<Location, Long> implements LocationDAO {

    public LocationDAOBean() {
        super(Location.class);
    }
}
