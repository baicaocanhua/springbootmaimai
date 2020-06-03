package com.maimai.springbootlast.util;

import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-23 09:50
 **/
public class Utils {
//    public static String GetDomainName(String url)
//    {
//        if (url == null)
//        {
//            throw new Exception("输入的url为空");
//        }
//        Regex reg = new Regex(@"(?<=://)([\w-]+\.)+[\w-]+(?<=/?)");
//        return reg.Match(url, 0).Value.Replace("/", string.Empty);
//    }

    public static void main(String[] args) throws MalformedURLException {
        URL  url = new URL("http://blog.csdn.net:9000/zhujianlin1990");

        String host = url.getHost();// 获取主机名

        System.out.println("host:"+host);// 结果 blog.csdn.net

        String uu="http://blog.csdn.net:9000/zhujianlin1990/123/index.html";
        System.out.println(getURI(uu,false));
    }

    public static String getURI(String url, boolean containProjectName) {
        String regx = "(?:https?://)(?:(?:\\w+\\.){2,3}|[a-zA-Z0-9]+)(?:\\w+)(?::[0-9]+)?" + (containProjectName ? "(?:/\\w+/)" : "")
                + "([^?]*)";
        Pattern p = Pattern.compile(regx);
        Matcher matcher = p.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }




}
