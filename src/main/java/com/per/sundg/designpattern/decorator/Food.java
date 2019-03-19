package com.per.sundg.designpattern.decorator;

/**
 * <br>
 *
 * @ClassName: Food
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/19 10:04
 * @VERSION 1.0
 */
public class Food {

    private String name;

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    public String make(){
        return name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}
