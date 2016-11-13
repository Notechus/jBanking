package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Location;
import com.sip.jbanking.domain.to.LocationTO;
import org.mapstruct.Mapper;

/**
 * @author notechus.
 */
@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationTO locationToLocationTO(Location location);
}
