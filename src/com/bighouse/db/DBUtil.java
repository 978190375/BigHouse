package com.bighouse.db;

import java.sql.SQLException;

/**
 * 数据库操作类
 */
public class DBUtil {
    /**
     * 执行增删改操作
     * @param po
     * @return
     */
    public static int executeUpdate(DB_PO po){
        int flag=-1;
        try {
            flag=po.psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }

    /**
     * 执行查询操作
     * @param po
     */
    public static void executeQuery(DB_PO po){
        try {
            po.rs=po.psmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭链接资源
     * @param po
     */
    public static void closeSource(DB_PO po){

        if(po.rs!=null) {
            try {
                po.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(po.psmt!=null) {
            try {
                po.psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(po.conn!=null) {
            try {
                po.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}


