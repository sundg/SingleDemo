package com.per.sundg.designpattern.proxy;

import com.per.sundg.jdk.stream.Hero;
import org.junit.jupiter.api.Test;

/**
 * <br>
 *
 * @ClassName: Hello
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/14 9:39
 * @VERSION 1.0
 */
public class ProxyTest {

    @Test
    public void testStaticProxy(){
        Hello hello = new Hello();
        StaticProxyHello staticProxyHello = new StaticProxyHello(hello);
        staticProxyHello.say();
    }

    @Test
    public void testDynamicProxy(){
        IHello hello= (IHello) new DynamicProxyHello().bind(new Hello());
        hello.say();
      /*  IHello proxyTarget = (IHello) new DynamicProxyHello(new Hello()).getProxyTarget();
        proxyTarget.say();*/
    }

    @Test
    public void testDynamicProxy2(){
        IHello proxyTarget = (IHello) new DynamicProxyHello(new Hello()).getProxyTarget();
        proxyTarget.say();
    }

    @Test
    public void testCglibProxy(){
        Hello2 cglibTarget = (Hello2) new CglibProxyHello(new Hello2()).getCglibProxy();
        cglibTarget.say();
    }
}
