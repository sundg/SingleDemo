package com.per.sundg.designpattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <br>
 * Cglib代理的实现思路：
 *      1、实现MethodInterceptor接口
 *      2、通过Enhancer代理类生成器生成代理对象
 *
 *  Cglib代理的优点：
 *      解决了jdk动态代理中目标对象必须要实现一个或多个接口的问题
 *      Cglib代理允许为非接口类型创建一个Java代理
 *  jdk代理与Cglib代理区别：
 *      1、Proxy是基于接口的方式进行代理
 *      2、Enhancer是基于继承的方式代理
 * @ClassName: CglibProxyHello
 * @Description:  Hello类的Cglib代理类
 * @Author sundg
 * @Date 2019/3/14 9:41
 * @VERSION 1.0
 */
public class CglibProxyHello implements MethodInterceptor {

    //目标对象
    private Hello2 target;

    public CglibProxyHello(Hello2 hello) {
        this.target = hello;
    }


    /**
     * 创建代理对象
     * @Author sundg
     * @Date 2019/3/14 11:33
     * @Param []
     * @return java.lang.Object
     * @VERSION 1.0
     **/
    public Object getCglibProxy(){
        //代理类生成器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类（代理类）
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");
        Object result = method.invoke(target, objects);
        System.out.println("提交事务...");
        return result;
    }
}
