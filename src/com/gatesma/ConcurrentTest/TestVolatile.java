package com.gatesma.ConcurrentTest;

/**
 * Copyright (C), 2020
 * FileName: TestVolatile
 * Author:   Marlon
 * Email: gatesma@foxmail.com
 * Date:     2020/1/16 20:40
 * Description: Volatile
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while(true) {
            if(td.isFlag()) {
                System.out.println("---------------");
                break;
            }
        }
    }



}

class ThreadDemo implements Runnable {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("Flag = " + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}