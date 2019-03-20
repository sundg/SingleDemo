package com.per.sundg.designpattern.factory.factorymethod;

import java.util.Map;

/**
 * 工厂方法模式_产品接口
 *
 * @author popkidorc
 *
 */
public interface IMyMessage {

     Map<String, Object> getMessageParam();

     void setMessageParam(Map<String, Object> messageParam);

     void sendMesage() throws Exception;// 发送通知/消息

}