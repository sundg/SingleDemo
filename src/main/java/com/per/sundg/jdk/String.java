package com.per.sundg.jdk;

import org.junit.jupiter.api.Test;

/**
 * <br>
 *
 * @ClassName: String
 * @Description: String源码学习
 * @Author sundg
 * @Date 2019/1/31 15:08
 * @VERSION 1.0
 */
public class String {

    public static void main(String[] args) {
        java.lang.String str1 = "1";
        java.lang.String str2 = new java.lang.String("1");
        System.out.println(str1 == str2);
    }

    @Test
    public void test(){
        java.lang.String str1 = "1";
        java.lang.String str2 = new java.lang.String("1");
        System.out.println(str1 == str2);
    }


}
