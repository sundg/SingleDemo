package com.per.sundg.designpattern.singleton;

/**
 * <br>
 *  设计思路：
 *      1、私有化构造函数
 *      2、提供一个静态方法获取该类实例
 * @ClassName: SingletonDemo
 * @Description: 单例模式
 * @Author sundg
 * @Date 2019/3/14 13:23
 * @VERSION 1.0
 */
public class SingletonDemo {


    public String name ="单例模式";

    //静态常量
    private static final SingletonDemo ehan = new SingletonDemo();
    private static final SingletonDemo ehan2;

    //静态代码块
    static {
        ehan2 = new SingletonDemo();
    }
    private SingletonDemo() {
    }



    /**
     * 饿汉式：
     *      优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
     *      缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
     * @Author sundg
     * @Date 2019/3/14 13:55
     * @Param []
     * @return com.per.sundg.designpattern.singleton.SingletonDemo
     * @VERSION 1.0
     **/
    public static SingletonDemo getInstance2(){
        //静态常量式
        /*return ehan;*/
        //静态代码块式
        return ehan2;
    }



    private static SingletonDemo lazy;
    /**
     * 懒汉式
     * @Author sundg
     * @Date 2019/3/14 13:34
     * @Param []
     * @return com.per.sundg.designpattern.singleton.SingletonDemo
     * @VERSION 1.0
     **/
    public static SingletonDemo getInstance(){
        /**
         * 线程不安全
         **/
        if (lazy == null) {
            lazy = new SingletonDemo();
        }
        /**
         * 线程不安全 （同步代码块）
         *      假如一个线程进入了if (singleton == null)判断语句块，
         *      还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
         **/
        if (lazy == null) {
            synchronized (SingletonDemo.class){
                lazy = new SingletonDemo();
            }
        }
        return lazy;
    }

    private static SingletonDemo singletonDemo;
    /**
     * 双重检查，解决多线程问题
     * 优点：
     *      线程安全；延迟加载；效率较高
     **/
    public static SingletonDemo getInstance3() {
        if (singletonDemo == null){
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    /**
     * 静态内部类[推荐用]
     *  这种方式跟饿汉式方式采用的机制类似，但又有不同。
     *  两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
     *  不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
     *  而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，
     *  调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
     *  类的静态属性只会在第一次加载类的时候初始化。
     *  JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
     *
     * 优点：
     *      避免了线程不安全，延迟加载，效率高。
     **/
    public static class SingletonInstance{
        private static SingletonDemo staticInstance = new SingletonDemo();
    }

    public static SingletonDemo getInstances4(){
        return SingletonInstance.staticInstance;
    }


}
