package com.per.sundg.thread;

/**
 * <br>
 * t1先运行，这个时候flag==true,先锁定obj1,然后睡眠1秒钟
 * 而t1在睡眠的时候，另一个线程t2启动，flag==false,先锁定obj2,然后也睡眠1秒钟
 * t1睡眠结束后需要锁定obj2才能继续执行，而此时obj2已被t2锁定
 * t2睡眠结束后需要锁定obj1才能继续执行，而此时obj1已被t1锁定
 * t1、t2相互等待，都需要得到对方锁定的资源才能继续执行，从而死锁
 *
 * 死锁产生的原因：
 *      ●当两个线程相互调用Thread.join()
 *      ●当两个线程使用嵌套的同步块，一个线程占用了另外一个线程必需的锁，互相等待时被阻塞就有可能出现死锁。
 * @ClassName: DeadLock
 * @Description: 死锁
 * @Author sundg
 * @Date 2019/3/22 14:10
 * @VERSION 1.0
 */
public class DeadLock implements Runnable {

    private static Object object1 =new Object();
    private static Object object2 =new Object();
    private boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "运行");
        System.out.println(Thread.currentThread().getState());
        if(flag) {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "已经锁住object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    // 执行不到这里
                    System.out.println("1秒钟后，"+Thread.currentThread().getName()+ "锁住object2");
                }
            }
        } else {
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + "已经锁住object2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    // 执行不到这里
                    System.out.println("1秒钟后，"+Thread.currentThread().getName()+ "锁住object1");
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true), "线程1");
        Thread t2 = new Thread(new DeadLock(false), "线程2");

        t1.start();
        t2.start();
    }
}
