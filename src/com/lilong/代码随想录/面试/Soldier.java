package com.lilong.代码随想录.面试;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : lilong
 * @date : 2023-11-03 11:22
 * @description :
 */
public class Soldier {
    /**
     * 两个线程来回打印
     *
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    System.out.println("a");
                    lock.unlock();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    System.out.println("b");
                    lock.unlock();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}

