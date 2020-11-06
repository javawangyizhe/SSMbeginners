package com.offcn.utils;

import com.offcn.pojo.Card;

public class MyStaticFactory {
    /**
     * 静态方法，生产静态对象
     */
    public static Object getBean(){
        System.out.println("这是静态工厂");
        return new Card();
    }
}
