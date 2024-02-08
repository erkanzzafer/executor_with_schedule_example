/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.executor_with_schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 * @author zafer
 */
public class Executor_with_schedule {

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("count: " + coreCount);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(coreCount);
        service.schedule(new Task(), 10, SECONDS);
        service.scheduleAtFixedRate(new Task(), 15, 10, SECONDS);
        service.scheduleWithFixedDelay(new Task(), 15, 10, SECONDS);

        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {

        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }

}
