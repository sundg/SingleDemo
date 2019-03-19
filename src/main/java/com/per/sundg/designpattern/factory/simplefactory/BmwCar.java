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
public class BmwCar implements ICar {
    @Override
    public void product() {
        System.out.println("生产宝马汽车");
    }
}
