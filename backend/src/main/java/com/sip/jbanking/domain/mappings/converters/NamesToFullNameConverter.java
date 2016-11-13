package com.sip.jbanking.domain.mappings.converters;

import org.mapstruct.Mapper;

/**
 * @author notechus.
 */
public final class NamesToFullNameConverter {

    public static String convert(String name, String surname) {
        return name + " " + surname;
    }
}
