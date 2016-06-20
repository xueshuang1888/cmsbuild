package com.mingsoft.util.sms;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;

public class SmsTest {

	
	//客服电话
	public static String SERVICEPHONENUMBER = "**********";//客服电话号码
	/**
	 * 发短信核心接口 先注掉 要用的的时候打开
	 * @param js
	 */
	public static void sendSms(JSONObject js) {
	    
		String username = "amandaiec";// 短信宝帐户名
		String pass = new MD5Sms().MD5Sms("H1ll0y1wu");// 短信宝帐户密码，md5加密后的字符串
		String phone = js.getString("phoneNumber");// 电话号码
		String content = js.getString("content");
		try {
			content = URLEncoder.encode("【中宏置业】" + content, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}// 发送内容

		String url = "";
		// 短信发送 api
		url = "http://api.smsbao.com/sms?u=USERNAME&p=PASSWORD&m=PHONE&c=CONTENT";
		url = url.replace("USERNAME", username);
		url = url.replace("PASSWORD", pass);
		url = url.replace("PHONE", phone);
		url = url.replace("CONTENT", content);
		HttpSendSms send = new HttpSendSms(url);
	    try {
            send.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	/**
	 * 发动态校验码
	 * @param js
	 */
	public static void sendCaptcha(JSONObject js) {
		js.put("content", "动态校验码为[" + js.getString("cap") + "]");
		sendSms(js);
	}

	/**
	 * 生成动态校验码
	 * @return
	 */
	public static String createCaptcha() {
		Random r = new Random();
		Double d = r.nextDouble();
		System.out.println(d);
		String s = d + "";
		s = s.substring(3, 3 + 6);
		System.out.println(s);
		return s;
	}

	/**
	 * 发送客服短信
	 * @param content
	 */
	public static void sendService(String content) {
		JSONObject js = new JSONObject();
		js.put("phoneNumber", SERVICEPHONENUMBER);
		js.put("content", content);
		sendSms(js);
	}
	
	public static void main(String[] args) {
		// String username = "amandaiec";// 短信宝帐户名
		// String pass = new MD5Sms().MD5Sms("H1ll0y1wu");// 短信宝帐户密码，md5加密后的字符串
		// String phone = "18698836737";// 电话号码
		// String content = "test";
		// try {
		// content = URLEncoder.encode("【南苏相】 动态短信验证码 123789","UTF-8");
		// } catch (UnsupportedEncodingException e1) {
		// e1.printStackTrace();
		// }// 发送内容
		//		
		// String url = "";
		// //短信发送 api
		// url =
		// "http://api.smsbao.com/sms?u=USERNAME&p=PASSWORD&m=PHONE&c=CONTENT";
		// //查询余额API
		// // url = "http://www.smsbao.com/query?u=USERNAME&p=PASSWORD";
		//		
		// url = url.replace("USERNAME", username);
		// url = url.replace("PASSWORD", pass);
		// url = url.replace("PHONE", phone);
		// url = url.replace("CONTENT", content);
		//		
		// System.out.println("url---" + url);
		// HttpSendSms send = new HttpSendSms(url);
		// try {
		// send.send();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		Random r = new Random();
		Double d = r.nextDouble();
		System.out.println(d);
		String s = d + "";
		s = s.substring(3, 3 + 6);
		System.out.println(s);
	}
	
	
/*	JSONObject js = new JSONObject();
	js.put("phoneNumber", ppuser.getPhone());
	js.put("content", "注册成功");
	SmsTest st = new SmsTest();
	st.sendSms(js);*/
}
