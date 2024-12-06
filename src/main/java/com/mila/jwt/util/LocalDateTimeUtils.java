package com.mila.jwt.util;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public final class LocalDateTimeUtils {

    private LocalDateTimeUtils(){

    }
    public static Date toDate(LocalDateTime localDateTime){
        return Date.from(localDateTime.toInstant(ZoneOffset.UTC));
    }

}
