package com.maimai.springbootlast.client;

import com.maimai.springbootlast.entity.Gril;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-08 11:25
 **/
public class ListClient {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println(list);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) == 3) {
//                list.remove(i--);
//            }
//        }
//        System.out.println(list);


        Integer reduce = Stream.of(5, 2, 3, 4).reduce(10, (count, item) -> {
            System.out.println("count=" + count);
            System.out.println("item=" + item);
            return count + item;
        });
        System.out.println(reduce);

        String re = Stream.of("1", "2", "3").reduce("0", (x, y) -> x + "," + y);
        System.out.println(re);

        List<Gril> list1 = new ArrayList<>(8);
        Gril g1 = new Gril();
        g1.setName("g1");
        g1.setId(1);

        Gril g2 = new Gril();
        g2.setName("g2");
        g2.setId(2);
        list1.add(g1);
        list1.add(g2);
        Map<String, Integer> map = list1.stream().collect(Collectors.toMap(Gril::getName, Gril::getId));
        System.out.println(map);
    }
}
