package com.offcn.test;

import com.offcn.dao.HumanDao;
import com.offcn.dao.impl.HumanDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HumanMain {
    public static void main(String[] args) {
        HumanDao human = new HumanDaoImpl();
        HumanDao humanProxy =(HumanDao) Proxy.newProxyInstance(human.getClass().getClassLoader(),
                human.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Double arg = (Double) args[0];
                        if (arg > 1000) {
                            System.out.println("喝茶");
                            method.invoke(human, args);
                            System.out.println("高兴");
                        }
                        return null;
                    }
                });
        humanProxy.dance(1001.0);
    }
}
