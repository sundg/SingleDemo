package com.per.sundg.dbpool.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <br>
 *
 * @ClassName: DBPoolConnection
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/6 14:27
 * @VERSION 1.0
 */
public class DbPoolConnection {
    private static DbPoolConnection dbPoolConnection = null;
    private static DruidDataSource druidDataSource = null;
    static {
        Properties properties = loadPropertiesFile("druid.properties");
        try {
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);    //DruidDataSrouce工厂模式
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据库连接池单例
     * @return
     */
    public static synchronized DbPoolConnection getInstance(){
        if (null == dbPoolConnection){
            dbPoolConnection = new DbPoolConnection();
        }
        return dbPoolConnection;
    }

    /**
     * 返回druid数据库连接
     * @return
     * @throws SQLException
     */
    public DruidPooledConnection getConnection() throws SQLException {
        return druidDataSource.getConnection();
    }
    /**
     * @param fullFile 配置文件名
     * @return Properties对象
     */
    private static Properties loadPropertiesFile(String fullFile) {
        String webRootPath = null;
        if (null == fullFile || fullFile.equals("")){
            throw new IllegalArgumentException("Properties file path can not be null" + fullFile);
        }
        webRootPath = DbPoolConnection.class.getClassLoader().getResource("").getPath();
        InputStream inputStream = null;
        Properties p =null;
        try {
            inputStream = new FileInputStream(new File(webRootPath + File.separator + fullFile));
            p = new Properties();
            p.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream){
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return p;
    }
}


