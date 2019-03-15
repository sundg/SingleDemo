package com.per.sundg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * BIO编程,存在线程阻塞问题
 * @Author sundg
 **/
public class SocketServerDemo {

	static int port = 1234;
	static String charset = "UTF-8";
	public static void main(String[] args) throws Exception {
		testOne();
	}

	/**
	 * 测试服务端接受客户端发送的消息
	 * @throws Exception
	 * @date 2019年1月21日下午3:13:08
	 * @author sundg
	 */
	public static void testOne() throws Exception{
		/**
		 * step1:启动socket服务器
		 * 		1、设置监听端口
		 * 		2、实例化socket服务器
		 * step2:接受socket客户端请求
		 * step3:解析客户端请求,IO操作
		 * step4:关闭客户端socket
		 * step5:关闭服务端
		 */
		ServerSocket server = new ServerSocket(port);
		//此处会一直等到客户端连接才继续执行（线程阻塞）
		System.out.println("等待客户端连接");
		Socket socket = server.accept();
		System.out.println("客户端已连接");
		InputStream input = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder builder = new StringBuilder();
		while(true){
			// 循环读取数据
			// read() 阻塞点
			System.out.println("准备读取数据");
			len = input.read(bytes);
			System.out.println("数据已读取");
			if (len != -1){
				builder.append(new String(bytes,0,len,charset));
			} else {
				break;
			}
		}
		System.out.println("接收到的请求:"+builder);
		input.close();
		socket.close();
		server.close();
	}

	/**
	 * 测试服务端接受客户端发送的消息并返回信息给客户端
	 * @throws Exception
	 * @date 2019年1月21日下午3:14:35
	 * @author sundg
	 */
	public static void testTwo() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
		InputStream input = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder builder = new StringBuilder();
		while((len = input.read(bytes)) != -1){
			builder.append(new String(bytes, 0, len, charset));
		}
		System.out.println(sdf.format(new Date()) +"接收到的请求:"+builder);
		OutputStream output = socket.getOutputStream();
		String message = "服务端返回的数据";
		output.write(message.getBytes(charset));
		input.close();
		output.close();
		socket.close();
		server.close();
		System.out.println(sdf.format(new Date()) + message);
	}

	/**
	 * 通过约定符号读取
	 * @throws Exception
	 * @date 2019年1月23日下午1:58:19
	 * @author sundg
	 */
	public static void testThree() throws Exception{
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
		InputStream input = socket.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(input,charset));
		String line;
		StringBuilder builder = new StringBuilder();
		while((line = reader.readLine()) != null && "sun".equals(line)){
			builder.append(line);
		}
		System.out.println("接收到的请求:"+builder);
		OutputStream output = socket.getOutputStream();
		String message = "服务端返回的数据";
		output.write(message.getBytes(charset));
		input.close();
		output.close();
		socket.close();
		server.close();
	}

	/**
	 * 指定长度
	 * @throws Exception
	 * @date 2019年1月23日下午2:50:31
	 * @author sundg
	 */
	public static void testFour() throws Exception{
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
		InputStream input = socket.getInputStream();
		byte[] bytes;
		while(true){
			int first = input.read();
			if(first == -1){
				break;
			}
			int second = input.read();
			int length = (first << 8) +second;

			bytes = new byte[length];
			input.read(bytes);
			System.out.println("服务端接收到的信息："+new String(bytes, charset));
		}
		input.close();
		socket.close();
		server.close();
	}

	/**
	 * 通过线程池并发处理socket
	 * @throws Exception
	 * @date 2019年1月23日下午3:05:06
	 * @author sundg
	 */
	public static void testFive() throws Exception{
		ServerSocket server = new ServerSocket(port);

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		while (true) {
			Socket socket = server.accept();
			Runnable runnable=() ->{
				try {
					// 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
					InputStream inputStream = socket.getInputStream();
					byte[] bytes;
					while(true){
						int first = inputStream.read();
						if(first == -1){
							break;
						}
						int second = inputStream.read();
						int length = (first << 8) +second;

						bytes = new byte[length];
						inputStream.read(bytes);
						System.out.println("服务端接收到的信息："+new String(bytes, charset));
					}
					inputStream.close();
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
			newFixedThreadPool.submit(runnable);
		}
	}
}
