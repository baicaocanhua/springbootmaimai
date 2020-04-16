package com.maimai.springboot.controller;

import java.io.*;

public class FileController {
    public static void main(String[] args) {
        //read1();

        System.out.println( readfilebyInputStream2());
    }

    private static void read() {
        File file = new File("D:\\pydemo\\222.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int n = 0;
            StringBuffer sBuffer = new StringBuffer();
            while (n != -1)  //当n不等于-1,则代表未到末尾
            {
                n = fileInputStream.read();//读取文件的一个字节(8个二进制位),并将其由二进制转成十进制的整数返回
                char by = (char) n; //转成字符
                sBuffer.append(by);
            }
            System.out.println(sBuffer.toString());
        } catch (IOException e) {

        }
    }

    private static void read1() {
        File file = new File("D:\\pydemo\\222.txt");
        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis, "UTF-8"); //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static String readfilebyInputStream(){
        String result="";
        File file=new File("D:\\pydemo\\222.txt");
        InputStream inputstream=null;
        byte []b=new byte[11];//字节数组大小
        try {
            inputstream=new FileInputStream(file);
            int temp;
            int length=0;
            while((temp=inputstream.read())!=-1) {//每次读取一个字节，存放在byte数组中
                //每次读取11个字节,并转换成String
                if(length==11) {
                    result+=new String(b,0,length,"UTF-8");
                    length=0;
                }
                b[length]=(byte)temp;
                length++;
            }
            return result+=new String(b,0,length,"UTF-8");//退出循环的时候，最后一个字节数组可能并没有11个字节
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        finally {
            if(inputstream!=null) {
                try {
                    inputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public  static String readfilebyInputStream2(){
        String result="";
        File file=new File("D:\\pydemo\\222.txt");
        InputStream inputstream=null;
        byte []b=new byte[1024];//接受1024个字节
        try {
            inputstream=new FileInputStream(file);
            int temp;
            int length=0;
            while((temp=inputstream.read())!=-1) {//每次读取一个字节，存放在byte数组中
                b[length]=(byte)temp;
                length++;
                System.out.println(length);
            }
            return new String(b,0,length,"UTF-8");//将字节转换成String 
        }
        catch(Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        finally {
            if(inputstream!=null) {
                try {
                    inputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
