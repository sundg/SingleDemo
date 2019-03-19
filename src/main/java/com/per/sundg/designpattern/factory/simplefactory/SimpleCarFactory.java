package com.per.sundg.designpattern.factory.simplefactory;

/**
 * <br>
 *
 * @ClassName: SimpleCarFactory
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/19 11:36
 * @VERSION 1.0
 */
public class SimpleCarFactory {
    public static ICar product(String type) {
        switch (type) {
            case "benz":
                return new BenzCar();
            case "bmw":
                return new BmwCar();
            case "ford":
                default:
                return new FordCar();
        }
    }
}
