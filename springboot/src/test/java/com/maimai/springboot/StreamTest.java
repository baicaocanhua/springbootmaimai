package com.maimai.springboot;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {
    @Test
    public  void t1(){

        IntStream.range(0, 1_000_000);
        int a=1000000;
        int b=1_000_000;
        System.out.println(a==b);
        long t0 = System.nanoTime();
        System.out.println(t0);
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(new Date().getTime());


        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        System.out.println(startsWithJ.test("JQZASDAD"));




        List<Integer> numbers = Lists.newArrayList(1,2,3,4,5);




        List<String> collect = numbers.stream().map(n->"数字:"+n).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    @Test
    public void t2(){
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        //求集合元素只和
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);
    }
    @Test
    public void t3(){


        String[] words = new String[]{"Hello","World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(s->Arrays.stream(s))

                .distinct()
                .collect(Collectors.toList());
        a.forEach(System.out::print);
        a.forEach(s-> System.out.print(s));
    }

    public void t4(){
        Stream<String> stream = Stream.of("aaa", "bbb", "ccc");
       List<String> list= stream.collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
