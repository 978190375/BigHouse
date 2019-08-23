package com.bighouse.db;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class SourceUtil {
    private static DruidDataSource dataSource=null;

    static{
        dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://188.131.242.210:3306/bighouse?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("tpshop");
        dataSource.setPassword("978190375");
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(50);
        dataSource.setMinIdle(10);
        dataSource.setMaxWait(5000*60);
    }

    /**
     * Druid获取链接
     * @return
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
