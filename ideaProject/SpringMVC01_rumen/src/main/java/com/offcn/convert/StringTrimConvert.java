package com.offcn.convert;

import org.springframework.core.convert.converter.Converter;

public class StringTrimConvert implements Converter<String,String> {
    @Override
    public String convert(String s) {
        String trim = s.trim();
        return trim;
    }
}
