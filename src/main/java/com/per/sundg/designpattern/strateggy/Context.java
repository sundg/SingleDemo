package com.per.sundg.designpattern.strateggy;

/**
 * <br>
 *
 * @ClassName: Context
 * @Description: 环境(Context)角色：持有一个Strategy的引用
 * @Author sundg
 * @Date 2019/3/14 15:28
 * @VERSION 1.0
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(int price){
        strategy.calc(price);
    }
}
