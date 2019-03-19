package com.per.sundg.designpattern.decorator;

/**
 * <br>
 *
 * @ClassName: Bread
 * @Description: TODO
 * @Author sundg
 * @Date 2019/3/19 10:06
 * @VERSION 1.0
 */
public class Bread extends Food {
    private Food basicFood;

    public Bread(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make() + "+面包";
    }
}
