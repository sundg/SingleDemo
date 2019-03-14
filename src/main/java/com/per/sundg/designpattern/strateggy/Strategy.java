package com.per.sundg.designpattern.strateggy;

/**
 * <br>
 *
 * @ClassName: Strategy
 * @Description: 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口
 * @Author sundg
 * @Date 2019/3/14 15:29
 * @VERSION 1.0
 */
public interface Strategy {
    void calc(int price);
}
