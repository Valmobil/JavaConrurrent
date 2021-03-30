package com.svami.soft.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class a_singleThread {

  public static void main(String[] args) {

    //Singe runnable
    Executor executor = Executors.newSingleThreadExecutor();
    executor.execute(() -> {
      System.out.println("Hello World");
    });
  }

}
