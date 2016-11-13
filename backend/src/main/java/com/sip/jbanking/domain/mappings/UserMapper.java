package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.to.UserTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author notechus.
 */
@Mapper(uses = {AccountMapper.class, LocationMapper.class, TransactionMapper.class}, componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "fullName", expression = "java(com.sip.jbanking.domain.mappings.converters.NamesToFullNameConverter.convert(user.getName(),user.getSurname()))")
    })
    UserTO userToUserTO(User user);
}
