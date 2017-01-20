package com.sip.jbanking.domain.mappings;

import org.mapstruct.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author notechus.
 */
@Mapper(componentModel = "spring")
public class DateMapper {

    public static final String DATE_TIME_FORMATTER = "dd-MM-yyyy HH:mm:ss";
    private final SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMATTER);

    public String asString(Date date) {
        return date != null ? format.format(date) : null;
    }

    public Date asDate(String date) {
        try {
            return date != null ? format.parse(date) : null;
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
