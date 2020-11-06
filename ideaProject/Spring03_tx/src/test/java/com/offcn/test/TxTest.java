package com.offcn.test;

import com.offcn.service.AccountService;
import com.offcn.service.impl.AccountServiceImpl;
import com.offcn.utils.TxManager;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class TxTest {
    private AccountService service = new AccountServiceImpl();
    @Test
    public void Test1(){
        service.transfer(1001,1003,1d);
    }

    /**
     * 代理模式执行account
     */
    @Test
    public void Test2(){
        AccountService servicePorxy = (AccountService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        try {
                            TxManager.start();
                            method.invoke(service,args);
                            TxManager.commit();
                        } catch (Exception e) {
                            TxManager.rollback();
                            e.printStackTrace();
                        }finally {
                            TxManager.relex();
                        }

                        return null;
                    }
                });
        servicePorxy.transfer(1001,1003,4d);
    }

}
