package com.per.sundg.jdk;


import org.junit.Test;

import java.util.Map;

/**
 * <br>
 *
 * @ClassName: HashMap
 * @Description: HashMap源码学习
 * @Author sundg
 * @Date 2019/1/31 15:10
 * @VERSION 1.0
 */
public class HashMap {

  public static void main(String[] args) {
    Map<java.lang.String, java.lang.String> map = new java.util.HashMap<>(6);
    map.put("1","2");
  }


  @Test
  public void test(){
    Map<java.lang.String, java.lang.String> map = new java.util.HashMap<>(6);
    map.put("1","2");
    System.out.println("123");
  }

}
