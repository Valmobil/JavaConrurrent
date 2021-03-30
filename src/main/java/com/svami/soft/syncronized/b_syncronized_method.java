package com.svami.soft.syncronized;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class b_syncronized_method {

  static int variable1 = 0;
  static Integer variable2 = 0;
  static volatile Integer variable3 = 0;
  static AtomicInteger variable4 = new AtomicInteger(0);

  static Object object = new Object();


  public static void main(String[] args) {

    for (int i = 0; i < 1000; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          //all types of variables work fine with block syncronization
          //that contains at least variable changes

          extracted();
          System.out.println("int: " + variable1);
          System.out.println("Int: " + variable2);
          System.out.println("Vol: " + variable3);
          System.out.println("Ato: " + variable4);
        }
      }).start();

    }
    System.out.println("Main program end.");
  }

  private static synchronized void extracted() {
    variable1++;
    variable2++;
    variable3++;
    variable4.incrementAndGet();
  }

}
