package com.per.sundg.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * @Description: httpclient请求测试发送短信
 * @Author sundg
 * @Date 2019/1/30 11:10
 **/
public class PhoneMsgTest {
	public static void main(String[] args) {
		System.out.println(getUrl());
		String url=getUrl();
		httpGet(url);
	}
	
	private static void httpGet(String url){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(20000).setConnectTimeout(20000).build();
		HttpGet httpget = new HttpGet(url);
		httpget.addHeader("Accept", "*/*");
		httpget.addHeader("Connection", "keep-alive");
		httpget.addHeader("Accept-Encoding", "gzip, deflate");
		CloseableHttpResponse response;
		try {
			response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();
			System.out.println(response.getStatusLine());
			if (entity != null) {
				String params=EntityUtils.toString(entity);
				System.out.println(entity);
				System.out.println(params);
			}
			response.close();
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static String getUrl(){
		String ip="120.26.65.203";
		int port=8800;
		String account="suopai-zhigj";//用户账号
		String pswd="sp123456.";//密码
		String mobile="15906285552,13851552561";
		String msg="南京智管家短信平台测试";
		boolean needstatus=true;//true 需要状态报告    false 不需要状态报告
		
		String product="";
		String extno="";
		

		String url = "http://"+ip+":"+port+"/msg/HttpSendSM?account="+account+"&pswd="+pswd+"&mobile="+mobile+"&msg="+msg+"&needstatus="+needstatus;
		String batchurl = "http://"+ip+":"+port+"/msg/HttpBatchSendSM?account="+account+"&pswd="+pswd+"&mobile="+mobile+"&msg="+msg+"&needstatus="+needstatus;
		return batchurl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
