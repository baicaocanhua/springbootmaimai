package com.maimai.springbootlast.client;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-17 14:47
 **/
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {

        String uu="http://www.cas.com:8001/asda/wdsd/asdad";
        System.out.println(getDomain(uu));

        int a=189;
        int c=189;

        Integer aa=189;
        Integer cc=189;
        System.out.println(a==c);
        System.out.println(aa==a);//自动拆箱
        System.out.println(aa==cc);


//        int[] nums = {2, 7, 11, 15,8,1};
//        int target = 9;
//        int[] aa = twoSum(nums, target);
//        System.out.println(JSON.toJSONString(aa));
//
//
//
//        Map<String,Object> map=new HashMap<>();
//        map.put("a","aaa");
//        if("aaa"==map.get("a")){
//
//        }
    }

    public static String getDomain(String url) {
        String result = "";
        int j = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                j++;
                if (j == 2)
                    startIndex = i;
                else if (j == 3)
                    endIndex = i;
            }

        }
        result = url.substring(startIndex + 1, endIndex);
        return result.split(":")[0];
    }



}
