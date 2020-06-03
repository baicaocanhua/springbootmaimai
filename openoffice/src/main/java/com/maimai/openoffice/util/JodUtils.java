package com.maimai.openoffice.util;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import java.io.*;
import java.net.ConnectException;

/**
 * https://www.iteye.com/blog/76581349-2070041
 *用OpenOffice实现Word转Html完整方案
 *
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-05-18 17:34
 **/
public class JodUtils {

    /**
     * jod转换类
     * @param File source   office文件
     * @param File html     转换输出html文件
     * @throws IOException
     */
    public static void converter(File source, File html) throws IOException {
        OpenOfficeConnection con = new SocketOpenOfficeConnection("49.235.232.253", 8100);
        try {
            con.connect();
        } catch (ConnectException e) {
            System.err.println("文件转换出错，请检查OpenOffice服务是否启动。");
            e.printStackTrace();
        }
        DocumentConverter converter = new OpenOfficeDocumentConverter(con);
        converter.convert(source, html);
        con.disconnect();

        formatStyle(html);
    }

    /**
     * html样式转换
     * @param File html html文件
     */
    public static void formatStyle(File html) {
        String file_path = null;
        StringBuffer s_html = new StringBuffer();

        try {
            //读取文件路径
            file_path = html.getPath();

            //读取文件
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(html), "GBK"));
            while (br.ready()) {
                s_html.append(br.readLine());
            }
            br.close();
            // 删除临时文件
            html.delete();

            //写文件
            BufferedWriter writer = null;
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file_path)),"GBK"));
            writer.write(formatStyleUtils(s_html.toString()));
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * html样式转换工具
     * @param String html   html代码
     * @return
     */
    public static String formatStyleUtils(String html) {

        //去除左对齐样式
        //P { margin-bottom: 0.21cm; direction: ltr; color: #000000; /**text-align: justify;**/ widows: 0; orphans: 0 }
        html = html.replaceFirst("text-align: justify;", "");

        //图片居中样式
        html = html.replaceAll("<IMG", "<CENTER><IMG");

        return html;
    }

}
