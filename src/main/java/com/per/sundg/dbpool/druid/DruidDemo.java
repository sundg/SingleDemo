package com.per.sundg.dbpool.druid;

import com.per.sundg.dbpool.c3p0.C3P0Demo;
import org.junit.jupiter.api.Test;

/**
 * <br>
 *
 * @ClassName: DruidDemo
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/6 14:40
 * @VERSION 1.0
 */
public class DruidDemo {

    @Test
    public void test(){
        DruidDao druidDao = new DruidDao();
        String sql = "update gcs_active_info set publisherName='好信用平台' where id=1";
        druidDao.insert(sql);
    }
}
