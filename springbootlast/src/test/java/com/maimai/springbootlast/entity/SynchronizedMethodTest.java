package com.maimai.springbootlast.entity;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedMethodTest {

    @Test
    void calculate() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedMethod summation = new SynchronizedMethod();
        IntStream.range(0, 1000).forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000, summation.getSum());


    }

    @Test
    void synchronizedCalculate() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedMethod summation = new SynchronizedMethod();
        IntStream.range(0, 1000).forEach(count -> service.submit(summation::synchronizedCalculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000, summation.getSum());


    }
}