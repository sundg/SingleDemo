package com.per.sundg.designpattern.proxy;

/**
 * <br>
 *
 * @ClassName: Hello
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/14 9:39
 * @VERSION 1.0
 */
public class Hello implements IHello {
    @Override
    public void say() {
        System.out.println("目标对象say hello");
    }
}
