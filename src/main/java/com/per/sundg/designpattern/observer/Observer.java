package com.per.sundg.designpattern.observer;

/**
 * <br>
 *
 * @InterfaceName: Person
 * @Description: 观察者模式:顶层接口
 * @Author sundg
 * @Date 2019/3/19 9:16
 * @VERSION 1.0
 */
public interface Observer {
    //观察者可以通过这个接口接收到被观察者信息
    void getMessage(String message);
}
