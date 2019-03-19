package com.per.sundg.designpattern.decorator;

/**
 * <br>
 *
 * @ClassName: ConcreteComponet
 * @Description: ConcreteComponent为具体实现类，也是被装饰类，他本身是个具有一些功能的完整的类。
 * @Author sundg
 * @Date 2019/3/19 10:41
 * @VERSION 1.0
 */
public class ConcreteComponet implements Component {
    @Override
    public void biu() {
        System.out.println("biubiubiu");
    }
}
