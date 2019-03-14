package com.per.sundg.designpattern.strateggy;

import org.junit.jupiter.api.Test;

/**
 * <br>
 *  实现方式：a) 提供公共接口或抽象类，定义需要使用的策略方法。（策略抽象类）
 *           b) 多个实现的策略抽象类的实现类。（策略实现类）
 *           c) 环境类，对多个实现类的封装，提供接口类型的成员量，可以在客户端中切换。
 *           d) 客户端 调用环境类 进行不同策略的切换。
 *
 *      注：Jdk中的TreeSet和 TreeMap的排序功能就是使用了策略模式。
 *
 *
 *  策略模式的优点
 *  　　（1）策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。
 *          恰当使用继承可以把公共的代码移到父类里面，从而避免代码重复。
 *      （2）使用策略模式可以避免使用多重条件(if-else)语句。
 *          多重条件语句不易维护，它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，
 *          统统列在一个多重条件语句里面，比使用继承的办法还要原始和落后。
 *
 *  策略模式的缺点
 *  　　（1）客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，
 *          以便适时选择恰当的算法类。换言之，策略模式只适用于客户端知道算法或行为的情况。
 *      （2）由于策略模式把每个具体的策略实现都单独封装成为类，如果备选的策略很多的话，
 *          那么对象的数目就会很可观。
 * @ClassName: StrategyPatternTest
 * @Description: 策略模式(客户端)
 * @Author sundg
 * @Date 2019/3/14 14:57
 * @VERSION 1.0
 */
public class StrategyPatternTest {

    @Test
    public void test(){
        ConcreteStrategyB concreteStrategyA = new ConcreteStrategyB();
        Context context = new Context(concreteStrategyA);
        context.execute(100);
    }
}
