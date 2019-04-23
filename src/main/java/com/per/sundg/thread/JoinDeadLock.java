package com.per.sundg.thread;


/**
 * <br>
 *
 * @ClassName: JoinDeadLock
 * @Description: Thread.join()方法导致死锁
 * @Author sundg
 * @Date 2019/3/22 15:00
 * @VERSION 1.0
 */
public class JoinDeadLock {

    private Thread thread;

    public JoinDeadLock() {
        this.thread = new Thread(new RealThread());
    }

    private class RealThread implements Runnable{
        @Override
        public void run() {
            System.out.println("thread is starting");
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread is stoping");
        }
    }

    public void start() {
       thread.start();
    }
}

class Starter {
    public static void main(String[] args) {
        new JoinDeadLock().start();
    }
}
