package com.svami.soft.pool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class c_CallableTreadPool implements Callable<String> {

  public static void main(String args[]) throws ExecutionException, InterruptedException {
    //Get ExecutorService from Executors utility class, thread pool size is 10
    ExecutorService executor;
    executor = Executors.newFixedThreadPool(Runtime.getRuntime()
        .availableProcessors() * 3);
    //create a list to hold the Future object associated with Callable
    List<Future<String>> list = new ArrayList<Future<String>>();
    //Create MyCallable instance
    Callable<String> callable = new c_CallableTreadPool();
    //Put tasks in thread pool
    for (int i = 0; i < 100; i++) {
      //submit Callable tasks to be executed by thread pool
      Future<String> future = executor.submit(callable);
      //add Future to the list, we can get return value using Future
      list.add(future);
    }
    System.out.println("Print result");
    for (Future<String> fut : list) {
      try {
        //print the return value of Future, notice the output delay in console
        // because Future.get() waits for task to get completed
        System.out.println(new Date() + "::" + fut.get());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

//    System.out.println(new Date() + "::" + list.get(10).get());
//    System.out.println(new Date() + "::" + list.get(50).get());
//    System.out.println(new Date() + "::" + list.get(60).get());

    //shut down the executor service now
    executor.shutdown();
    System.out.println("End of Program");
  }

  @Override
  public String call() throws Exception {
    Thread.sleep(1000);
    //return the thread name executing this callable task
    System.out.println("Task execution: " + Thread.currentThread().getName());
    return Thread.currentThread().getName();
  }
}
