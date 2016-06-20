package com.mingsoft.util.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class HttpSendSms {
	String urlString;

	/*
	 * public static void main(String[] args) throws Exception { HttpTest client =
	 * new HttpTest(网址); client.run(); }
	 */
	public HttpSendSms(String urlString) {
		this.urlString = urlString;
	}

	public void send() throws Exception {
		// 生成一个URL对象
		URL url = new URL(urlString);
		// 打开URL
		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		// 得到输入流，即获得返回值
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream()));
		String line;
		JSONObject j = new JSONObject();
		// 读取返回值，进行判断
		while ((line = reader.readLine()) != null) {
			System.out.println("line---"+line);
			String result = line;
			if ("0".equals(result)) {
				System.out.println("发送成功");
			}
		}
	}
}
