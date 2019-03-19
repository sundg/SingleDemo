package com.per.sundg.designpattern.proxy;

/**
 * <br>
 * 静态代理的实现思路：
 *      1、继承或实现同一个父类或接口（IHello）
 *      2、将目标类（Hello）绑定到代理类（StaticProxyHello）之上
 *      3、代理类通过方法重写或实现接口方法，在方法中调用目标类的对应方法、
 *
 *  静态代理的优点：
 *      1、易扩展：可以做到在不修改目标对象的功能前提下,对目标功能扩展
 *      2、解耦合：代理类不需要知道目标类的具体实现
 *  静态代理的缺点：
 *      1、代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * @ClassName: ProxyHello
 * @Description:  Hello类的静态代理类
 * @Author sundg
 * @Date 2019/3/14 9:41
 * @VERSION 1.0
 */
public class StaticProxyHello implements IHello {

    //维护一个目标对象
    private Hello hello;

    public StaticProxyHello(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void say() {
        //代理类自身的逻辑
        System.out.println("代理类开始调用");
        hello.say();
        System.out.println("代理类结束调用");
    }
}
