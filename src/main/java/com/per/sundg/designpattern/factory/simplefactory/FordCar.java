package com.per.sundg.designpattern.factory.simplefactory;

/**
 * <br>
 *
 * @ClassName: Car
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/19 11:27
 * @VERSION 1.0
 */
public class FordCar implements ICar {
    @Override
    public void product() {
        System.out.println("生产福特汽车");
    }
}
