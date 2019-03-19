package com.per.sundg.designpattern.factory.simplefactory;

import org.junit.jupiter.api.Test;

/**
 * <br>
 *
 * @ClassName: SimpleCarFactoryTest
 * @Description: 简单工厂模式测试类
 * @Author sundg
 * @Date 2019/3/19 11:36
 * @VERSION 1.0
 */
public class SimpleCarFactoryTest {
    @Test
    public void test(){
        ICar car = SimpleCarFactory.product("benz1");
        car.product();
    }
}
