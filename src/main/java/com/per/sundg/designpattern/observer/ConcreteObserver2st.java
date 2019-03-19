package com.per.sundg.designpattern.observer;

/**
 * <br>
 *
 * @ClassName: ObserverPerson1st
 * @Description: 观察者模式:具体观察者（订阅者）
 * @Author sundg
 * @Date 2019/3/19 9:08
 * @VERSION 1.0
 */
public class ConcreteObserver2st implements Observer {
    private String name = "观察者2";
    @Override
    public void getMessage(String message) {
        System.out.println(name + "接受到被观察者的信息内容->" + message);
    }
}
