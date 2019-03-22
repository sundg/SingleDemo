package com.per.sundg.base;

import org.junit.jupiter.api.Test;

/**
 * <br>
 *
 * @ClassName: Demo
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/22 10:16
 * @VERSION 1.0
 */
public class DemoTwo implements ICarOne,ICarTwo {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        run();
    }


    @Override
    public void run() {
        System.out.println("123");

    }
}
