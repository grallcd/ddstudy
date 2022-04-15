package com.ddstudy.app.a23;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author grallcd
 * @since 2022/4/15
 */
@Slf4j
public class MyDateTimeFormatter implements Formatter<Date> {

    private final String desc;

    public MyDateTimeFormatter(String desc) {
        this.desc = desc;
    }


    @Override
    public Date parse(String text, Locale locale) throws ParseException {

        log.info(">>>>>>>>>>:{}", desc);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy|MM|dd");
        return sdf.parse(text);
    }

    @Override
    public String print(Date date, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy|MM|dd");
        return sdf.format(date);
    }
}
