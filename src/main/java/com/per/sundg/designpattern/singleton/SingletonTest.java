package com.per.sundg.designpattern.singleton;


import org.junit.Test;

/**
 * <br>
 *
 * @ClassName: SingletonTest
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/14 14:30
 * @VERSION 1.0
 */
public class SingletonTest {

    @Test
    public void test(){
        EnumSingleton enumVar1 = EnumSingleton.INSTANCES;
        System.out.println(enumVar1);
        EnumSingleton enumVar2 = EnumSingleton.INSTANCES;
        System.out.println(enumVar2);
        System.out.println("枚举单例："+(enumVar1==enumVar2));
        SingletonDemo instances1 = SingletonDemo.getInstances4();
        SingletonDemo instances2 = SingletonDemo.getInstances4();
        System.out.println(instances1);
        System.out.println(instances2);
        System.out.println("静态内部类单例："+(instances1==instances2));
    }
}
