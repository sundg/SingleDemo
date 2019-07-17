package com.per.sundg.dbpool.druid;

import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <br>
 *
 * @ClassName: DruidDao
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/6 14:36
 * @VERSION 1.0
 */
public class DruidDao {

    public void insert(String sql){
        //获取数据连接池单例
        DbPoolConnection dbp = DbPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ps = null;
        try {
            //从数据库连接池中获取数据库连接
            conn = dbp.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps){
                    ps.close();
                }
                if (null != conn){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
