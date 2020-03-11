package com.maimai.qiyeweixin.webchat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maimai.qiyeweixin.common.MyX509trustManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-05 12:02
 **/
public class WeChatSync {
    /*获取token*/
    public static String getSendMsgToken(String corpid,String corpsecret) throws Exception {
        String requestUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+corpsecret+"";//注意与AgenId（若有） 对应使用

        String requestMethod = "GET";
        String outputStr = null;
        StringBuffer buffer = null;

        //创建SSLContext
        SSLContext sslContext = SSLContext.getInstance("SSL");
        TrustManager[] tm = {new MyX509trustManager()};
        //初始化
        sslContext.init(null, tm, new java.security.SecureRandom());

        //获取SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        URL url = new URL(requestUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod(requestMethod);
        //设置当前实例使用的SSLSoctetFactory
        conn.setSSLSocketFactory(ssf);
        conn.connect();
        //往服务器端写内容
        if (null != outputStr) {
            OutputStream os = conn.getOutputStream();
            os.write(outputStr.getBytes("utf-8"));
            os.close();
        }
        //读取服务器端返回的内容
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        buffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }

        //JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
        JSONObject jsonObject = JSON.parseObject(buffer.toString());
        String accesstoken = jsonObject.getString("access_token");
        System.out.println("获取到的Token---------"+accesstoken);
        return accesstoken;
    }


    //发送信息
    public static String SendMsgtoBody(JSONObject outputStr,String access_token) throws Exception {
        String requestUrl="https://qyapi.weixin.qq.com/cgi-bin/message/send";
        String requestMethod = "POST";
        StringBuffer buffer = null;

        //创建SSLContext
        SSLContext sslContext = SSLContext.getInstance("SSL");
        TrustManager[] tm = {new MyX509trustManager()};
        //初始化
        sslContext.init(null, tm, new java.security.SecureRandom());
        ;
        //获取SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        URL url = new URL(requestUrl + "?access_token=" + access_token);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod(requestMethod);
        //设置当前实例使用的SSLSoctetFactory
        conn.setSSLSocketFactory(ssf);
        conn.connect();
        //往服务器端写内容
        if (null != outputStr) {
            OutputStream os = conn.getOutputStream();
            os.write(outputStr.toString().getBytes("utf-8"));
            os.close();
        }
        //读取服务器端返回的内容
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        buffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        JSONObject json1 = JSON.parseObject(buffer.toString());
        System.out.println(json1);
        String msg = json1 .getString("errmsg");
        return msg ;

    }


}
