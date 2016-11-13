package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.to.AccountTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author notechus.
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mappings({
            @Mapping(source = "owner.username", target = "username"),
            @Mapping(target = "fullName",
                    expression = "java(com.sip.jbanking.domain.mappings.converters.NamesToFullNameConverter.convert(account.getOwner().getName(),account.getOwner().getSurname()))")})
    AccountTO accountToAccountTO(Account account);
}
