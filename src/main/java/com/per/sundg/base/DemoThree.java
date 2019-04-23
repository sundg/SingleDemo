package com.per.sundg.base;


import org.junit.Test;

/**
 * <br>
 *
 * @ClassName: Demo
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/22 10:16
 * @VERSION 1.0
 */
public class DemoThree extends CarOne implements ICarOne {

    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        run();
    }

    @Override
    public void run() {
       // super.run();
        System.out.println("123");
    }
}
