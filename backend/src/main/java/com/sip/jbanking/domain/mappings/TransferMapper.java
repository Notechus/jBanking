package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.to.TransferTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author notechus.
 */
@Mapper(uses = {AccountMapper.class, DateMapper.class}, componentModel = "spring")
public interface TransferMapper {

    @Mappings({
            @Mapping(source = "currency.name", target = "currency"),
            @Mapping(source = "sender.accountNumber", target = "senderAccNumber"),
            @Mapping(source = "receiver.accountNumber", target = "receiverAccNumber"),
            @Mapping(source = "description", target = "title"),
            @Mapping(source = "timestamp", target = "timestamp")
    })
    TransferTO transactionToTransactionTO(Transfer transaction);

    List<TransferTO> tranferListToListTO(List<Transfer> transferList);
}
