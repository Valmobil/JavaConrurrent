package com.svami.soft.service;

public class HelperMethods {

  public static void randomSleep() throws InterruptedException {
    Thread.sleep((long) (Math.random() * 1000));
  }

}
