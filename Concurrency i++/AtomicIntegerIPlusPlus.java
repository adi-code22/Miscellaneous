package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicIntegerIPlusPlus {

    private static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {
        final int totalThreadCount = 10;
        final int numberOfIterations = 1000;
        try{
            ExecutorService executor = Executors.newFixedThreadPool(10);
            for (int threadCount = 0; threadCount < totalThreadCount; threadCount++) {
                executor.submit(()-> {
                    for (int iterator = 0; iterator < numberOfIterations; iterator++) {
                        i.getAndIncrement();
                    }
                });
            }
            executor.shutdown();
            while (!executor.isTerminated()) {}
            System.out.println("Expected Value of i is: " + totalThreadCount * numberOfIterations);
            System.out.println("Current Value of i is: " + i.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}