package com.per.sundg.designpattern.factory.factorymethod;


/**
 * <br>
 * 实现方式：
 *      1、定义一个共同的父接口IMyMessage
 *      2、定义一个抽象类MyAbstractMessage实现父接口IMyMessage
 *      3、定义多个实现类继承实现父接口IMyMessage的抽象类MyAbstractMessage
 *      4、定义一个工厂接口IMyMessageFactory
 *      3、定义一个工厂类实现工厂接口IMyMessageFactory，编写一个方法根据参数类型返回IMyMessage类型对象
 * 调用：
 *       ####用父接口接受工厂创建的实例对象####
 *        IMyMessageFactory myMessageFactory = new MyMessageFactory();
 *        IMyMessage myMessage;
 *        myMessage = myMessageFactory.createMessage("SMS");
 *        myMessage.sendMesage();
 * @ClassName: SimpleCarFactoryTest
 * @Description: 工厂方法模式测试类
 * @Author sundg
 * @Date 2019/3/19 11:36
 * @VERSION 1.0
 */
public class MyFactoryMethodMain {

    public static void main(String[] args) {
        IMyMessageFactory myMessageFactory = new MyMessageFactory();
        IMyMessage myMessage;
        // 对于这个消费者来说，不用知道如何生产message这个产品，耦合度降低
        try {
            // 先来一个短信通知
            myMessage = myMessageFactory.createMessage("SMS");
            myMessage.sendMesage();

            // 来一个oa待办
            myMessage = myMessageFactory.createMessage("OA");
            myMessage.sendMesage();

            // 来一个邮件通知
            myMessage = myMessageFactory.createMessage("EMAIL");
            myMessage.sendMesage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}