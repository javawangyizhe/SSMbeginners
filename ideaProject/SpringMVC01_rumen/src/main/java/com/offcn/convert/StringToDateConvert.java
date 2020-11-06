package com.offcn.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConvert implements Converter<String,Date> {

    @Override
    public Date convert(String dateStr) {
        try {
            if(dateStr.contains("/")){
                return new SimpleDateFormat("yyyy/MM/dd").parse(dateStr);
            }
            if(dateStr.contains(".")){
                return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            }
            if(dateStr.contains(":")){
                return new SimpleDateFormat("yyyy:MM:dd").parse(dateStr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
