package com.per.sundg.designpattern.decorator;

/**
 * <br>
 *
 * @ClassName: Decorator
 * @Description: Decorator是装饰类，实现了Component接口的同时还在内部维护了一个ConcreteComponent的实例，并可以通过构造函数初始化。
 *              而Decorator本身，通常采用默认实现，他的存在仅仅是一个声明：我要生产出一些用于装饰的子类了。而其子类才是赋有具体装饰效果的装饰产品类。
 * @Author sundg
 * @Date 2019/3/19 10:43
 * @VERSION 1.0
 */
public class Decorator implements Component {

    public Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void biu() {
        this.component.biu();
    }
}
