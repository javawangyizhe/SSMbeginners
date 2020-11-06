/*
package com.offcn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyFactory {
    static Properties prop = new Properties();
    static{
        try {
        InputStream resourceAsStream = MyFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        prop.load(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static Object getBean(String name){
        String value = prop.getProperty(name);
        try {
            Class clz = Class.forName(value);
            Object o = clz.newInstance();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
*/
