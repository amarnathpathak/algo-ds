package com.hp.ps.mythreadpool;

import com.hp.ds.mythreadpool.MyThreadPool;

public class MyThreadPoolExample {

    public static void main(String[] args) {
        MyThreadPool threadPool = new MyThreadPool(3, 10);

        threadPool.start();
        for (int i = 0; i < 20; i++) {
            threadPool.submit(new MyTask(i));
        }
        threadPool.stop();
        System.out.println("Task Completed");
    }


}
