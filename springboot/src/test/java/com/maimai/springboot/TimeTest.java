package com.maimai.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeTest {
    @Test
   public void t1(){
       try {
           SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Date begin = dfs.parse("2004-01-02 11:30:24");
           Date end = dfs.parse("2004-03-26 13:31:40");
           long between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
           long day1 = between / (24 * 3600);
           long hour1 = between % (24 * 3600) / 3600;
           long minute1 = between % 3600 / 60;
           long second1 = between % 60 / 60;
           System.out.println("" + day1 + "天" + hour1 + "小时" + minute1 + "分" + second1 + "秒");
       } catch (Exception e) {

       }
   }
}
