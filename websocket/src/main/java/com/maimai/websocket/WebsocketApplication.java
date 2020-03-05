package com.maimai.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Enumeration;
import java.util.Properties;
import java.util.TimeZone;

@SpringBootApplication
public class WebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);

		System.out.println(TimeZone.getDefault()); //输出当前默认时区
		final TimeZone zone = TimeZone.getTimeZone("GMT+8"); //获取中国时区
		TimeZone.setDefault(zone); //设置时区
		System.out.println(TimeZone.getDefault()); //输出验证

		System.out.println("-----------------");
		final Properties p = System.getProperties();
		final Enumeration e = p.keys();
		while (e.hasMoreElements())
		{
			final String prt = (String) e.nextElement();
			final String prtvalue = System.getProperty(prt);
			System.out.println(prt + ":" + prtvalue);
		}
	}

}
