package com.maimai.springboot.controller;

import com.maimai.springboot.config.JenkinsConfiguration;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import com.offbytwo.jenkins.model.Job;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("jenkins")
@RestController
public class JenkinsController {

    @Autowired
    private JenkinsConfiguration jenkinsConfiguration;
    @Autowired
    private JenkinsHttpClient jenkinsHttpClient;

    @RequestMapping("getJobs")
    public Map<String, Job> getJobs() throws IOException {
        //JenkinsServer jenkins = new JenkinsServer(new URI("http://49.235.232.253:8080"), "baicaocanhua", "maimai5566")
        JenkinsServer jenkins = jenkinsConfiguration.getJenkinsServer(jenkinsHttpClient);
        Map<String, Job> map = jenkins.getJobs();
        return map;
    }

    // 定义一个遍历二维数组的功能函数
    public static void printArr2(int[][] a) {
        // 1. 拆开二维数组
        for (int i = 0; i < a.length; i++) {
            // 2. 拆开一维数组获取数据
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ,");
            }
        }
    }

    // 定义一个遍历二维数组的功能函数
    public static void printArr3(Object[][] a) {
        // 1. 拆开二维数组
        for (int i = 0; i < a.length; i++) {
            // 2. 拆开一维数组获取数据
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ,");
            }
        }
    }

    // 定义一个函数计算二维数组中的元素的累加和
    public static long getSum(int[][] a) {
        // 0. 定义一个结果变量
        long sum = 0L;
        // 1. 拆开二维数组
        for (int i = 0; i < a.length; i++) {
            // 2. 拆开一维数组获取数据
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }

    // 统计二维数组中元素的个数
    public static int getDataCount(int[][] a) {
        // 0. 记录元素个数
        int count = 0;
        // 1. 拆开二维数组
        for (int i = 0; i < a.length; i++) {
            // 2. 拆开一维数组获取数据
            for (int j = 0; j < a[i].length; j++) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] a = new int[][]{{23, 4, 5}, {2}, {4, 5, 78, 56, 90}};
//        printArr2(a);
//        System.out.println();
//        System.out.println("累加和是： " + getSum(a));
//        System.out.println("统计元素个数： " + getDataCount(a));
//        System.out.println("Hello World!");

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("map1-1", "map1-1-object");
        map1.put("map1-2", "map1-2-object");
        list.add(map1);
        System.out.println(map1.values());


        Map<String, Object> map2 = new HashMap<>();
        map2.put("map2-1", "map2-1-object");
        map2.put("map2-2", "map2-2-object");
        list.add(map2);
        printArr3(ListToArray(list, 2));
    }

    /**
     * @return Object[][]
     * @Title: ListToArray
     * @Description: list列表转换成二维数组
     * @Author: Administrator
     * @Since: 2018年1月7日下午2:01:25
     * @param: @param list
     * @param: @param KeyLenght每行的列数，按最长的计算
     * @param: @return
     */
    public static Object[][] ListToArray(List<Map<String, Object>> list, int KeyLenght) {
        if (CollectionUtils.isEmpty(list)) {
            return new Object[0][];
        }
        int size = list.size();
        Object[][] array = new Object[size][KeyLenght];
        for (int i = 0; i < size; i++) {//循环遍历所有行
            array[i] = list.get(i).values().toArray();//每行的列数
        }
        return array;
    }


}


