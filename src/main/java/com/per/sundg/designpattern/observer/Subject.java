package com.per.sundg.designpattern.observer;
/**
 * <br>
 *  观察者模式:
 *      1、主题
 *      2、观察者
 *      3、通知
 * @InterfaceName: Subject
 * @Description: 抽象主题(Subject)角色：把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。
 *                             抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
 * @Author sundg
 * @Date 2019/3/19 9:16
 * @VERSION 1.0
 */
public interface Subject {
    //添加观察者
    void attach(Observer observer);
    //删除观察者
    void detach(Observer observer);
    //通知观察者
    void notifyObservers();
}

