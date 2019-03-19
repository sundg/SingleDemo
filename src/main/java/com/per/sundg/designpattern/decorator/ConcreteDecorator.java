package com.per.sundg.designpattern.decorator;

/**
 * <br>
 *
 * @ClassName: ConcreteDecorator
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/19 10:45
 * @VERSION 1.0
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void biu() {
        System.out.println("123");
        this.component.biu();
    }
}
