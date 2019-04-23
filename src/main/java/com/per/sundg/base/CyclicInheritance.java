package com.per.sundg.base;



/**
 * <br>
 *  循坏继承在java中是不允许的，不仅仅局限于接口，类也不能循环继承。因为编译的时候，编译器不知道该先编译哪个。
 *  比如你的这个例子，编译class A的时候需要先编译A.IB，但是A.IB又是class A的内部接口
 * @ClassName: Demo
 * @Description: 循环继承问题
 * @Author sundg
 * @Date 2019/3/22 10:16
 * @VERSION 1.0
 */
/*
public class CyclicInheritance implements CyclicInheritance.IB {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        System.out.println(get());
    }

    @Override
    public int get() {
        return 100;
    }


    public interface IB{
        int get();
    }
}
*/
