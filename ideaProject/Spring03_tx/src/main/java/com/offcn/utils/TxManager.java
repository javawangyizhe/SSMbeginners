package com.offcn.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TxManager {
    private static  ThreadLocal<Connection> tl = new ThreadLocal<>();
    public static  Connection getConncetion(){
        Connection connection =tl.get();
        if(connection == null){
            connection = C3P0Tool.getConnection();
            tl.set(connection);
        }
        return  connection;
    }
    public static void start(){
        try {
            getConncetion().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void commit(){
        try {
            getConncetion().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void rollback(){
        try {
            getConncetion().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void relex(){
        try {
            tl.remove();
            getConncetion().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
