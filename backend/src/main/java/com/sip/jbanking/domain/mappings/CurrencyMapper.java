package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Currency;
import com.sip.jbanking.domain.to.CurrencyTO;
import org.mapstruct.Mapper;

/**
 * @author notechus.
 */
@Mapper(componentModel = "spring")
public interface CurrencyMapper {


    CurrencyTO currencyToCurrencyTO(Currency currency);
}
