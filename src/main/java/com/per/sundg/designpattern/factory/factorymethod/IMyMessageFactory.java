package com.per.sundg.designpattern.factory.factorymethod;


/**
 * 工厂方法模式_工厂接口
 *
 * @author popkidorc
 *
 */
public interface IMyMessageFactory {

    IMyMessage createMessage(String messageType);
}