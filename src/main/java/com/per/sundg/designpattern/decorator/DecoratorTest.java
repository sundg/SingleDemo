package com.per.sundg.designpattern.decorator;

import org.junit.jupiter.api.Test;

/**
 * <br>
 *   装饰器模式：
 *  1.抽象构件(Component)角色：给出一个抽象接口，以规范准备接收附加责任的对象。​​​​​​
 *  2.具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类。​​​​​​​
 *  3.装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。​​​​​​​
 *  4.具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。
 * @ClassName: DecoratorTest
 * @Description: 装饰器模式测试类
 * @Author sundg
 * @Date 2019/3/19 10:11
 * @VERSION 1.0
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());

    }

    @Test
    public void test(){
        Component component = new ConcreteDecorator(new ConcreteComponet());
        component.biu();
    }
}
