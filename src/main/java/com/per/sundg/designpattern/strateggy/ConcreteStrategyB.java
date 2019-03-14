package com.per.sundg.designpattern.strateggy;

/**
 * <br>
 *
 * @ClassName: ConcreteStrategyA
 * @Description: 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为
 * @Author sundg
 * @Date 2019/3/14 15:30
 * @VERSION 1.0
 */
public class ConcreteStrategyB implements Strategy{

    @Override
    public void calc(int price) {
        System.out.println("当前票价为："+price*0.7);
    }
}
