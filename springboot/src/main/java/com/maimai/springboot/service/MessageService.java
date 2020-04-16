package com.maimai.springboot.service;

import com.maimai.springboot.entity.MessageInfo;

public interface MessageService {
    void handleMessage(MessageInfo messageInfo);
}
