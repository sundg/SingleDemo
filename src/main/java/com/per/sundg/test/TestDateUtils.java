package com.per.sundg.test;

import com.per.sundg.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

  @Test
  public void test(){
    Integer i = 2;
    if (i.equals(2)) {
      log.info("#####");
    }
    if ("2".equals(i)) {
      log.info("$$$$$");
    }

    List<Integer> userIds = new ArrayList<>();
    for (int j = 0; j<userIds.size();j++) {
      log.info("!!!!!!!!!");
    }

  }
}
