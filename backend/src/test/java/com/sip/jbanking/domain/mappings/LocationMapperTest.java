package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Location;
import com.sip.jbanking.domain.to.LocationTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author notechus.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MappingsTestConfiguration.class)
public class LocationMapperTest {

    @Autowired
    private LocationMapper mapper;

    private static final String CITY = "City";
    private static final String POSTAL_CODE = "00-000";
    private static final String STATE = "State";
    private static final String STREET = "Some Street";

    @Test
    public void shouldMapLocationToLocationTO() {
        Location location = prepareLocation();

        LocationTO locationTO = mapper.locationToLocationTO(location);

        assertEquals(expectedLocationTO(), locationTO);
    }

    private LocationTO expectedLocationTO() {
        LocationTO l = new LocationTO();
        l.setStreet(STREET);
        l.setState(STATE);
        l.setPostalCode(POSTAL_CODE);
        l.setCity(CITY);

        return l;
    }

    private Location prepareLocation() {
        Location l = new Location();
        l.setCity(CITY);
        l.setPostalCode(POSTAL_CODE);
        l.setState(STATE);
        l.setStreet(STREET);

        return l;
    }

}