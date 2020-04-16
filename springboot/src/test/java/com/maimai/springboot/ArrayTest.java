package com.maimai.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayTest {
    @Test
    public void defined(){
        int[] arr=new int[5];
        printArray(arr);
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        printArray(arr);
    }
    private void printArray(int[] objects){
        for (int i = 0; i <objects.length ; i++) {
            System.out.println(objects[i]);
        }
    }
}
