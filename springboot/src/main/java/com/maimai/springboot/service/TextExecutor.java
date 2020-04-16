package com.maimai.springboot.service;

import java.util.concurrent.*;

public class TextExecutor {
    public ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);
    public ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
    public ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
    public ThreadPoolExecutor customerExecutorService = new ThreadPoolExecutor(3, 200, 0, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());

    public ExecutorService customerExecutorService11 = new ThreadPoolExecutor(3, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());



    public void testExecutorException() {
        for (int i = 0; i < 10; i ++) {
            // 增加isShutdown()判断
            if (!fixedExecutorService.isShutdown()) {
                fixedExecutorService.execute(new SayHelloRunnable());
            }
            fixedExecutorService.shutdown();
        }
    }

    public void testCustomerExecutorException() {

        try {
            for (int i = 0; i < 100; i ++) {
                customerExecutorService11.execute(new SayHelloRunnable());
            }
        }catch (Exception e){

        }

        System.out.println(customerExecutorService.getCorePoolSize());
        System.out.println(customerExecutorService.getActiveCount());
        System.out.println(customerExecutorService.getCompletedTaskCount());
    }

    private class SayHelloRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                System.out.println("hello world!");
            }

        }
    }


    public void test01(){
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS, queue, handler);
        for (int i = 0; i < 20; i ++){
            final int temp = i;
            pool.execute(() -> {
                System.out.println("客户" + temp + "来了.......");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("第几个报异常"+temp);
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        TextExecutor testExecutor = new TextExecutor();
        //testExecutor.testExecutorException();
        testExecutor.testCustomerExecutorException();
        //testExecutor.test01();


    }
}
