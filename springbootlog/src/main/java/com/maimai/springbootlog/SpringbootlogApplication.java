package com.maimai.springbootlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@Controller

@EnableScheduling
@EnableWebSocketMessageBroker
public class SpringbootlogApplication {

	private Logger logger = LoggerFactory.getLogger(SpringbootlogApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringbootlogApplication.class, args);
	}

	@RequestMapping("who")
	@ResponseBody
	public String who(){
		return "SpringbootlogApplication";
	}

	@RequestMapping("index")
	public String index(){
		return "index";
	}

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	int info=1;
	@Scheduled(fixedRate = 1000)
	public void outputLogger(){
		logger.info("测试日志输出"+info++);
	}
	/**
	 * 推送日志到/topic/pullLogger
	 */
	@PostConstruct
	public void pushLogger(){
		ExecutorService executorService= Executors.newFixedThreadPool(2);
		Runnable runnable=new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						LoggerMessage log = LoggerQueue.getInstance().poll();
						if(log!=null){
							if(messagingTemplate!=null)
								messagingTemplate.convertAndSend("/topic/pullLogger",log);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		executorService.submit(runnable);
	}

}
