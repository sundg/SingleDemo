package com.per.sundg.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketClientDemo {
	static int port = 1234;
	static String host ="127.0.0.1";
	static String charset = "UTF-8"; 
	
	public static void main(String[] args) throws Exception {
		testFour();
	}
	
	/**
	 * 测试客户端往服务端发送消息
	 * @throws Exception
	 * @date 2019年1月21日下午3:13:08
	 * @author sundg
	 */
	public static void testOne() throws Exception{
		/**
		 * step1:启动socke客户端
		 * 		1、设置端口
		 * 		2、设置主机host
		 * step2:发送socket客户端请求（IO流）
		 * step3:关闭IO流
		 * step4:关闭客户端socket
		 */
		Socket socket = new Socket(host,port);
		OutputStream output = socket.getOutputStream();
		String message = "测试发送socket请求";
		output.write(message.getBytes("UTF-8"));
		output.close();
		socket.close();
	}
	
	/**
	 * 测试客户端往服务端发送消息并接受服务端返回的消息
	 * @throws Exception
	 * @date 2019年1月21日下午3:15:27
	 * @author sundg
	 */
	public static void testTwo() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		System.out.println(sdf.format(new Date()));
		Socket socket = new Socket(host, port);
		OutputStream output = socket.getOutputStream();
		String message = "test send and accept";
		output.write(message.getBytes(charset));
		//后续只能接受数据
		socket.shutdownOutput();
		InputStream input = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder builder = new StringBuilder();
		while((len = input.read(bytes)) != -1){
			builder.append(new String(bytes, 0, len, charset));
		}
		System.out.println(sdf.format(new Date()) +builder);
		input.close();
		output.close();
		socket.close();
	}
	
	
	public static void testFour() throws Exception{
		Socket socket = new Socket(host, port);
		OutputStream output = socket.getOutputStream();
		String message = "客户端first";
		byte[] sendBytes = message.getBytes(charset);
		output.write(sendBytes.length >> 8);
		output.write(sendBytes.length);
		output.write(sendBytes);
		output.flush();
		message = "客户端second";
		byte[] secBytes = message.getBytes(charset);
		output.write(secBytes.length >> 8);
		output.write(secBytes.length);
		output.write(secBytes);
		output.flush();
		
		output.close();
		socket.close();
	}
}
