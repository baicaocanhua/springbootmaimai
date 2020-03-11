package com.maimai.qiyeweixin.controller;

import com.alibaba.fastjson.JSONObject;
import com.maimai.qiyeweixin.webchat.WeChatSync;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-05 11:58
 **/
@RestController
@RequestMapping("message")
public class SendMessageController {

    @Value("${qiyeweixin.corpid}")
    private String corpid;
    @Value("${qiyeweixin.maimaiMessage.Secret}")
    private String maimaiMessageSecret;
    @Value("${qiyeweixin.maimaiMessage.AgentId}")
    private String agentid;

    @RequestMapping("send")
    public String send() throws Exception {
        JSONObject insertdata = new JSONObject();
        JSONObject content = new JSONObject();
        content.put("content", "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。");
        insertdata.put("touser", "MaiGuoFeng");//这里是接收信息的人员id（多个人用 |  隔开）
        insertdata.put("msgtype", "text");
        insertdata.put("agentid", agentid);//此处一定要与上面的自建应用AgentId对应
        insertdata.put("text", content);
        insertdata.put("safe", 0);
        System.out.println(insertdata);
        String access_token = WeChatSync.getSendMsgToken(corpid, maimaiMessageSecret);
        return WeChatSync.SendMsgtoBody(insertdata, access_token);

    }

    @RequestMapping("getToken")
    public String getToken() throws Exception {
        return WeChatSync.getSendMsgToken(corpid, maimaiMessageSecret);
    }

    @RequestMapping("sendmarkdown")
    public String sendmarkdown() throws Exception {
        JSONObject insertdata = new JSONObject();
        JSONObject content = new JSONObject();
        content.put("content", "您的会议室已经预定，稍后会同步到`邮箱` \n" +
                "                >**事项详情** \n" +
                "                >事　项：<font color=\\\"info\\\">开会</font> \n" +
                "                >组织者：@miglioguan \n" +
                "                >参与者：@miglioguan、@kunliu、@jamdeezhou、@kanexiong、@kisonwang \n" +
                "                > \n" +
                "                >会议室：<font color=\\\"info\\\">广州TIT 1楼 301</font> \n" +
                "                >日　期：<font color=\\\"warning\\\">2018年5月18日</font> \n" +
                "                >时　间：<font color=\\\"comment\\\">上午9:00-11:00</font> \n" +
                "                > \n" +
                "                >请准时参加会议。 \n" +
                "                > \n" +
                "                >如需修改会议信息，请点击：[修改会议信息](https://work.weixin.qq.com)");
        insertdata.put("touser", "MaiGuoFeng");//这里是接收信息的人员id（多个人用 |  隔开）
        insertdata.put("msgtype", "markdown");
        insertdata.put("agentid", agentid);//此处一定要与上面的自建应用AgentId对应
        insertdata.put("markdown", content);
        insertdata.put("safe", 0);
        System.out.println(insertdata);
        String access_token = WeChatSync.getSendMsgToken(corpid, maimaiMessageSecret);
        return WeChatSync.SendMsgtoBody(insertdata, access_token);

    }

}
