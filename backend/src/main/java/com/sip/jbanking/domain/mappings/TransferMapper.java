package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.to.TransferTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author notechus.
 */
@Mapper(uses = AccountMapper.class, componentModel = "spring")
public interface TransferMapper {

    @Mappings({
            @Mapping(source = "currency.name", target = "currency"),
            @Mapping(source = "sender.accountNumber", target = "senderAccNumber"),
            @Mapping(source = "receiver.accountNumber", target = "receiverAccNumber"),
            @Mapping(source = "description", target = "title")

    })
    TransferTO transactionToTransactionTO(Transfer transaction);
}
