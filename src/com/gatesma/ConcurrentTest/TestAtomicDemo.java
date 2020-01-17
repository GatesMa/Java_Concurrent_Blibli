package com.gatesma.ConcurrentTest;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2020
 * FileName: TestAtomicDemo
 * Author:   Marlon
 * Email: gatesma@foxmail.com
 * Date:     2020/1/16 21:19
 * Description:
 */
public class TestAtomicDemo {

    /**
     * i++操作分为3个步骤
     */
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for(int i = 0;i < 10;i++) {
            new Thread(ad).start();
        }

        Hashtable<String, Object> ht = new Hashtable<>();
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
    }


}

class AtomicDemo implements Runnable {

    private int serialNumber = 0;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber++;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
