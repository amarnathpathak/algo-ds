package com.ps.mythreadpool;

public class MyTask implements Runnable {

    private int taskNo;

    public MyTask(int taskNo) {
        this.taskNo = taskNo;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + taskNo);
    }
}
