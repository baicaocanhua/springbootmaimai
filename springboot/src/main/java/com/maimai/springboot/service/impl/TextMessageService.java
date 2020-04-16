package com.maimai.springboot.service.impl;

import com.maimai.springboot.entity.MSG_TYPE;
import com.maimai.springboot.entity.MessageInfo;
import com.maimai.springboot.entity.MsgTypeHandler;
import com.maimai.springboot.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * @program: all
 * @description: 2
 * @author: zxb
 * @create: 2019-12-05 10:52
 **/
@Service
@MsgTypeHandler(value = MSG_TYPE.TEXT)
public class TextMessageService implements MessageService {
    @Override
    public void handleMessage(MessageInfo messageInfo) {
        System.out.println("处理文本消息 " + messageInfo.getContent());
    }
}
