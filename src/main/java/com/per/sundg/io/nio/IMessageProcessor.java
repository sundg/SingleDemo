package com.per.sundg.io.nio;

/**
 * Created by jjenkov on 16-10-2015.
 */
public interface IMessageProcessor {

    public void process(Message message, WriteProxy writeProxy);

}
