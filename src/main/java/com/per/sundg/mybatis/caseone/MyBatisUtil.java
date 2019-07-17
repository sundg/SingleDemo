package com.per.sundg.mybatis.caseone;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MyBatisUtil {
    private static SqlSessionFactory ssf;

    static {
        //加载配置文件
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        ssf = ssfb.build(MyBatisUtil.class.getClassLoader().getResourceAsStream("com/per/sundg/mybatis/caseone/iBatis.xml"));

    }

    public static SqlSession getSqlSession() {
        return ssf.openSession();
    }

    public static void main(String[] args) {
        System.out.print(MyBatisUtil.getSqlSession());
    }
}
