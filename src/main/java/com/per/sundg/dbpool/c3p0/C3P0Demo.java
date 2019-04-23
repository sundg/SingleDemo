package com.per.sundg.dbpool.c3p0;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.XmlUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <br>
 *
 * @ClassName: C3P0Demo
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/1 16:29
 * @VERSION 1.0
 */
public class C3P0Demo {

    private static final Logger LOGGER = Logger.getLogger(C3P0Demo.class);

    /**
     * 通过代码层使用c3p0
     * @Author sundg
     * @Date 2019/3/6 10:09
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void useByCode(){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://192.168.1.150:3306/gcs");
            cpds.setUser("root");
            cpds.setPassword("root");

            cpds.setMinPoolSize(5);
            cpds.setMaxPoolSize(100);
            try {
                Connection connection = cpds.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from gcs_active_info");
                ResultSet resultSet = preparedStatement.executeQuery();
                int first;
                int second;
                String third;
                int i= 0;
                while (resultSet.next()){
                    first = resultSet.getInt(1);
                    second = resultSet.getInt(2);
                    third = resultSet.getString(3);
                    LOGGER.info(first);
                    LOGGER.info(second);
                    LOGGER.info(third);
                    LOGGER.info("获取成功");

                    if (++i==5){
                        break;
                    }

                }


            } catch (SQLException e) {
                LOGGER.error("sql查询异常",e);
            }
        } catch (PropertyVetoException e) {
            LOGGER.error(e);
        }finally {
            cpds.close();

        }
    }


    @Test
    public void useByXml(){
        String currentClassPath = new C3P0Demo().getClass().getResource("").getPath();
        Document docResult =XmlUtil.readXML(currentClassPath+ File.separator+"c3p0.xml");

    }

    @Test
    public void useByProperties() throws IOException, PropertyVetoException, SQLException {
        Properties props = new Properties();
        String currentClassPath = new C3P0Demo().getClass().getResource("").getPath();

        InputStream in =
        new FileInputStream(currentClassPath+File.separator+"c3p0.properties");
        props.load(in);

        in.close();

        ComboPooledDataSource cpds = new ComboPooledDataSource();

        cpds.setDriverClass(props.getProperty("c3p0.driverClass"));
        cpds.setJdbcUrl(props.getProperty("c3p0.jdbcUrl"));
        cpds.setUser(props.getProperty("c3p0.user"));
        cpds.setPassword(props.getProperty("c3p0.password"));

        Console.log(props.getProperty("c3p0.driverClass"));
        Console.log(props.getProperty("c3p0.jdbcUrl"));
        Console.log(props.getProperty("c3p0.user"));
        Console.log(props.getProperty("c3p0.password"));
        Connection connection = cpds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from gcs_active_info");
        ResultSet resultSet = preparedStatement.executeQuery();
        int first;
        int second;
        String third;
        int i= 0;
        while (resultSet.next()){
            first = resultSet.getInt(1);
            second = resultSet.getInt(2);
            third = resultSet.getString(3);
            LOGGER.info(first);
            LOGGER.info(second);
            LOGGER.info(third);
            LOGGER.info("获取成功");

            if (++i==5){
                break;
            }

        }


    }

}
