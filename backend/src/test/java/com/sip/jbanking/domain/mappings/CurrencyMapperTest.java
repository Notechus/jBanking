package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Currency;
import com.sip.jbanking.domain.to.CurrencyTO;
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
public class CurrencyMapperTest {

    @Autowired
    private CurrencyMapper mapper;

    private static final String NAME = "PLN";
    private static final double PRICE = 1.99;

    @Test
    public void shouldMapCurrencyToCurrencyTO() {
        Currency currency = prepareCurrency();

        CurrencyTO currencyTO = mapper.currencyToCurrencyTO(currency);

        assertEquals(expectedCurrencyTO(), currencyTO);
    }

    private CurrencyTO expectedCurrencyTO() {
        CurrencyTO c = new CurrencyTO();
        c.setName(NAME);
        c.setPrice(PRICE);

        return c;
    }

    private Currency prepareCurrency() {
        Currency c = new Currency();
        c.setName(NAME);
        c.setPrice(PRICE);

        return c;
    }

}