package com.maimai.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * 8种创建Java线程的方式，你知道几个？
 * https://juejin.im/post/5d9dc5abe51d45783e4b6797?utm_source=gold_browser_extension
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {
    @Test
    public void thread1() {
        new CreatingThread01().start();
        new CreatingThread01().start();
        new CreatingThread01().start();
        new CreatingThread01().start();

    }

    @Test
    public void thread2() {
        new Thread(new CreatingThread02()).start();
        new Thread(new CreatingThread02()).start();
        new Thread(new CreatingThread02()).start();
        new Thread(new CreatingThread02()).start();
    }

    @Test
    public void thread3() {
        // Thread匿名类，重写Thread的run()方法
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " is running");
            }
        }.start();
        // Runnable匿名类，实现其run()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }).start();
        // 同上，使用lambda表达式函数式编程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        }).start();
    }

    @Test
    public void thread4() throws ExecutionException, InterruptedException {
        FutureTask<Long> task = new FutureTask<>(new CreatingThread04());
        new Thread(task).start();
        System.out.println("等待完成任务");
        Long result = task.get();
        System.out.println("任务结果：" + result);

    }

    @Test
    public void thread5() {
        Timer timer = new Timer();
        // 每隔1秒执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }, 0, 1000);
    }

    @Test
    public void thread6() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        }
    }




    @Test
    public void thread7() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // 串行，打印结果为12345
        list.stream().forEach(System.out::print);
        System.out.println();
        // 并行，打印结果随机，比如35214
        list.parallelStream().forEach(System.out::print);
    }

    @Test
    public void thread8() {
        new Thread(() -> {
            System.out.println("Runnable: " + Thread.currentThread().getName());
        }) {
            @Override
            public void run() {
                System.out.println("Thread: " + getName());
            }
        }.start();
    }

    class CreatingThread01 extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " is running");
        }
    }

    class CreatingThread02 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }

    class CreatingThread04 implements Callable<Long> {
        @Override
        public Long call() throws Exception {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " is running");
            return Thread.currentThread().getId();
        }

    }


    public static void main(String[] args) {
        Timer timer = new Timer();
        // 每隔1秒执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }, 0, 1000);
    }
}




