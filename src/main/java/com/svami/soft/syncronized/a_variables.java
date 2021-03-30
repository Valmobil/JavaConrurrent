package com.svami.soft.syncronized;

import java.util.concurrent.atomic.AtomicInteger;

public class a_variables {

  static int variable1 = 0;
  static Integer variable2 = 0;
  static volatile Integer variable3 = 0;
  static AtomicInteger variable4 = new AtomicInteger(0);

  public static void main(String[] args) {

    for (int i = 0; i < 10000; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          //we will see that only atomic works fine
          //all other types (including) volatile brings data discrepancy

          variable1++;
          variable2++;
          variable3++;
          variable4.incrementAndGet();

          System.out.println("int: " + variable1);
          System.out.println("Int: " + variable2);
          System.out.println("Vol: " + variable3);
          System.out.println("Ato: " + variable4);
        }
      }).start();

    }
    System.out.println("Main program end.");
  }

}
