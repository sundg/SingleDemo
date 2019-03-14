package com.per.sundg.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <br>
 * 动态代理的实现思路：
 *      1、目标对象继承或实现同一个父类或接口（IHello）
 *      2、将目标类（Hello）绑定到代理类（DynamicProxyHello）之上
 *      3、通过JDK反射机制动态的生成代理类
 *          Object object = Proxy.newProxyInstance(classLoader,interfaces,handler);
 *          handler实现方式：
 *              1、内部类实现
 *              2、代理类实现InvocationHandler接口
 *  动态代理的优点：
 *      1、解决了静态代理中代理类需要重写父类方法或实现接口的弊端
 *  动态代理的缺点：
 *      1、代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * @ClassName: DynamicProxyHello
 * @Description:  Hello类的动态代理类
 * @Author sundg
 * @Date 2019/3/14 9:41
 * @VERSION 1.0
 */
public class DynamicProxyHello implements InvocationHandler{

    //目标对象
    private Object target;

    public DynamicProxyHello() {
    }
    public DynamicProxyHello(Object target) {
        this.target = target;
    }

    public Object bind(Object object){
        this.target = object;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
    }

    /**
     * 生成代理对象
     * @Author sundg
     * @Date 2019/3/14 10:31
     * @Param []
     * @return java.lang.Object
     * @VERSION 1.0
     **/
    public Object getProxyTarget() {
       return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务1");
                        Object result = method.invoke(target, args);
                        System.out.println("开始事务2");
                        return result;
                    }
                });

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("动态代理");
        result = method.invoke(this.target, args);
        return result;
    }
}
