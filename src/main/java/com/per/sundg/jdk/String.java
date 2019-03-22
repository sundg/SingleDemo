package com.per.sundg.jdk;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <br>
 * 1.直接定义字符串变量的时候赋值，如果表达式右边只有字符串常量，那么就是把变量存放在常量池里面。
 * 2.new出来的字符串是存放在堆里面。　　　　
 * 3.对字符串进行拼接操作，也就是做"+"运算的时候，分2中情况：　　　　　　
 *      i.表达式右边是纯字符串常量，那么存放在栈里面。　　　　　　
 *      ii.表达式右边如果存在字符串引用，也就是字符串对象的句柄，那么就存放在堆里面。
 *  
 * @ClassName: String
 * @Description: String源码学习
 * @Author sundg
 * @Date 2019/1/31 15:08
 * @VERSION 1.0
 */
public class String {
    /**
     * 结果：str1、str2、str3、str5都是存在于常量池，str4由于表达式右半边有引用类型，
     * 所以str4存在于堆内存，而str5表达式右边没有引用类型，是纯字符串常量，就存放在了
     * 常量池里面。其实Integer这种包装类型的-128 ~ +127也是存放在常量池里面，
     * 比如Integer i1 = 10;Integer i2 = 10; i1 == i2结果是true，估计也是为了性能优化。
     * @Author sundg
     * @Date 2019/3/22 11:11
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void testOne(){
        java.lang.String str1 = "aaa";
        java.lang.String str2 = "bbb";
        java.lang.String str3 = "aaabbb";
        java.lang.String str4 = str1 + str2;
        java.lang.String str5 = "aaa" + "bbb";
        System.out.println(str3 == str4); // false
        System.out.println(str3 == str4.intern()); // true
        System.out.println(str3 == str5);// true
    }



}
