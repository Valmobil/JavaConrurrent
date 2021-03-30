package com.svami.soft.syncronized;

import java.util.concurrent.atomic.AtomicInteger;

public class b_syncronized_block {
  static int variable1 = 0;
  static Integer variable2 = 0;
  static volatile Integer variable3 = 0;
  static AtomicInteger variable4 = new AtomicInteger(0);

  static Object object = new Object();


  public static void main(String[] args) {

    for (int i = 0; i < 10000; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          //all variables increased w/o any issues

          synchronized (object) {
            variable1++;
            variable2++;
            variable3++;
            variable4.incrementAndGet();
          };

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
