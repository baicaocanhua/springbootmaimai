package com.maimai.springbootdev.controller;

import com.maimai.springbootdev.TransientMai;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @program: springbootmaimai
 * @description: 2
 * @author: zxb
 * @create: 2020-01-08 15:08
 **/
@RequestMapping("transient")
@RestController
public class TransientController {

    @RequestMapping("first")
    public String first() {
        //https://blog.csdn.net/qq_36819098/article/details/79794155
        //Java中Serializable的序列化、反序列化和transient关键字
        //https://blog.csdn.net/wangpei555/article/details/54586621
        //transient关键字及Serializable的序列化与反序列化
        TransientMai m = new TransientMai("xiaozhang", "123");
        ObjectOutputStream o;
        //序列化
        try {
            o = new ObjectOutputStream(
                    new FileOutputStream("logInfo.out"));
            o.writeObject(m);
            o.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //反序列化
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("logInfo.out"));
            TransientMai logInfo = (TransientMai) in.readObject();
            System.out.println(logInfo.toString());
        } catch (Exception e) {//deal with exception}
        }
        return "TransientMai";
    }

}

