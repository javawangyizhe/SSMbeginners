package com.offcn.utils;

import com.offcn.pojo.Card;

public class MyInstanceFactory {
    public Object getBean(){
        System.out.println("这是普通工厂");
        return new Card();
    }
}
