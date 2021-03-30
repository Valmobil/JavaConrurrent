package com.svami.soft.pool;

import com.svami.soft.service.HelperMethods;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class b_fixedThreadPool {
  static AtomicInteger index = new AtomicInteger(0);


  public static void main(String[] args) throws ExecutionException, InterruptedException {

    //Thread Pool with fixed thread q-ty
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    for (int i = 0; i < 10; i++) {
      executor.submit(() -> {
        int threadNum = index.getAndIncrement();
        HelperMethods.randomSleep();
        System.out.printf("Thread: %2d QueueSize: %d Pool: %s\n", threadNum, executor.getQueue().size(), Thread.currentThread().getName());
        return null;
      });
    }
    System.out.println("End of initialization.");
    executor.shutdown();
    System.out.println("End of program.");
  }
}
