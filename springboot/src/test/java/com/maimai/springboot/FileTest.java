package com.maimai.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @program: all
 * @description: test
 * @author: zxb
 * @create: 2019-11-14 10:55
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {
    @Test
    public void file1(){
        File file=new File("aa.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println("文件长度:"+file.length()+"字节");
    }
    @Test
    public void outputStreamTest() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
        // 写出数据
        fos.write(97); // 写出第1个字节
        fos.write(98); // 写出第2个字节
        fos.write(99); // 写出第3个字节
        // 关闭资源
        fos.close();
    }
    @Test
    public void outputStreamTest2() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("fos.txt");
        // 字符串转换为字节数组
        byte[] b = "麻麻我想吃烤山药".getBytes();
        // 写出字节数组数据
        fos.write(b);
        // 关闭资源
        fos.close();
    }

    @Test
    public void read1() throws IOException {
        // 使用文件名称创建流对象.
        FileInputStream fis = new FileInputStream("read.txt"); // read.txt文件中内容为abcde
        // 定义变量，作为有效个数
        int len ;
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[3];
        // 循环读取
        while (( len= fis.read(b))!=-1) {
            // 每次读取后,把数组变成字符串打印
            //System.out.println(new String(b));
//            String csn = Charset.defaultCharset().name();
//            System.out.println(csn);
            System.out.print(new String(b,0,len));
        }
        // 关闭资源
        fis.close();
    }

    @Test
    public void read2() throws IOException{
        FileInputStream inputStream = new FileInputStream("read.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
        }
    }
}
