package com.per.sundg.test;

import com.per.sundg.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * @Classname TestDateUtils
 * @Description 测试日期工具类
 * @Date 2019/4/26 10:14
 * @Created sundg
 */
@Slf4j
public class TestDateUtils {


  @Test
  public void testDate(){
    String startTime = DateUtils.formatDate(DateUtils.getFirstOfLastMonth(new Date()));
    String endTime = DateUtils.formatDate(DateUtils.getLastOfLastMonth(new Date()));
    log.debug("startTime="+startTime);
    log.debug("endTime="+endTime);
  }
}
