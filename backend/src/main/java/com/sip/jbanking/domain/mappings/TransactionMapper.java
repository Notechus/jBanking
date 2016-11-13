package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Transaction;
import com.sip.jbanking.domain.to.TransactionTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author notechus.
 */
@Mapper(uses = UserMapper.class, componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "currency.name", target = "currencyName")
    TransactionTO transactionToTransactionTO(Transaction transaction);
}
