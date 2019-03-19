package com.per.sundg.designpattern.observer;

/**
 * <br>
 *  观察者模式思想：
 *     1.抽象主题(Subject)角色：把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。
 *                             抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。​​​​​​​
 *     2.抽象观察者(Observer)角色：为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。​​​​​​
 *     3.具体主题(ConcreteSubject)角色：在具体主题内部状态改变时，给所有登记过的观察者发出通知。具体主题角色通常用一个子类实现。​​​​​​​
 *     4.具体观察者(ConcreteObserver)角色：该角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。
 *                                       通常用一个子类实现。如果需要，具体观察者角色可以保存一个指向具体主题角色的引用
 *
 * @ClassName: ObserverTest
 * @Description: 观察者模式测试类
 * @Author sundg
 * @Date 2019/3/19 9:25
 * @VERSION 1.0
 */
public class ObserverTest {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver1st concreteObserver1st = new ConcreteObserver1st();
        ConcreteObserver2st concreteObserver2st = new ConcreteObserver2st();

        //观察者（订阅者）注册到被观察者上
        concreteSubject.attach(concreteObserver1st);
        concreteSubject.attach(concreteObserver2st);

        //被观察者（发布者）发布信息
        concreteSubject.notifyObservers();
    }
}
