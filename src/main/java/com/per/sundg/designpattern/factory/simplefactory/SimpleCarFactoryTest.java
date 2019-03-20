package com.per.sundg.designpattern.factory.simplefactory;

import org.junit.jupiter.api.Test;

/**
 * <br>
 * 应用场景：
 *      #####实现类具有共同的行为。
 * 实现方式：
 *      1、定义一个共同的父接口ICar
 *      2、定义多个实现类实现父接口ICar
 *      3、定义一个工厂类，编写一个静态方法根据参数类型返回ICar类型对象
 * 调用：
 *       ####用父接口接受工厂创建的示例对象####
 *       ICar car = SimpleCarFactory.product("benz1");
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
