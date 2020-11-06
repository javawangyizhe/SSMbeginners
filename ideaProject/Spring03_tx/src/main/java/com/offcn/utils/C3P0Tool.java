package com.offcn.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Tool {
    private static DataSource dataSource = new ComboPooledDataSource("c3p0-config.xml");
    public static DataSource getDataSource(){
        return  dataSource;
    }
    public static Connection getConnection(){
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
