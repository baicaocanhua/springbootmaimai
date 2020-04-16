package com.maimai.springboot.entity;

import com.maimai.springboot.service.MessageService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: all
 * @description: 2
 * @author: zxb
 * @create: 2019-12-05 10:55
 **/
@Component
public class MessageServiceContext {

    private final Map<Integer, MessageService> handlerMap = new HashMap<>();

    public MessageService getMessageService(Integer type) {
        return handlerMap.get(type);
    }

    public void putMessageService(Integer code, MessageService messageService) {
        handlerMap.put(code, messageService);
    }
}
