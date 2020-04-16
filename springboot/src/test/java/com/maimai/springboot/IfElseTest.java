package com.maimai.springboot;

import com.maimai.springboot.entity.MSG_TYPE;
import com.maimai.springboot.entity.MessageInfo;
import com.maimai.springboot.entity.MessageServiceContext;
import com.maimai.springboot.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: all
 * @description: 2
 * @author: zxb
 * @create: 2019-12-05 11:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class IfElseTest {
    @Autowired
    MessageServiceContext messageServiceContext;

    @Test
    public void contextLoads() {
        // 构建一个文本消息
        MessageInfo messageInfo = new MessageInfo(MSG_TYPE.TEXT.code, "消息内容");
        MessageService messageService = messageServiceContext.getMessageService(messageInfo.getType());
        // 处理文本消息 消息内容
        // 可以看到文本消息被文本处理类所处理
        messageService.handleMessage(messageInfo);
    }

}
