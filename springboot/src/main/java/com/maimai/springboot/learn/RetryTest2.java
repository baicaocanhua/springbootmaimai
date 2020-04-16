package com.maimai.springboot.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.io.IOException;

public class RetryTest2 {
    private static final Logger LOGGER= LoggerFactory.getLogger(RetryTest2.class);
    public static void main(String[] args) throws IOException {
        RetryTemplate template = new RetryTemplate(); //使用超时重试策略

        TimeoutRetryPolicy policy = new TimeoutRetryPolicy(); //设置超时时间
        policy.setTimeout(200L);
        template.setRetryPolicy(policy); //设置重试执行代码
        for (String arg : args) {
            
        }

        RecoveryCallback<String> recoveryCallback = new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext retryContext) throws Exception {
                LOGGER.info("recover");
                return "recover";
            }
        };

                String result = template.execute(new RetryCallback<String, IOException>() {
            @Override
            public String doWithRetry(RetryContext context) {
                int count=context.getRetryCount();

                LOGGER.info("Execute callback .{}",count);
                //if(count!=5){
                int i = 1/0;
               // }

                return "Successfully";
            }
        },recoveryCallback);
    }
}
