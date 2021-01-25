package com.ds.mythreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    private BlockingQueue<Runnable> workQueue;
    private List<MyThreadPoolWorker> workThread;

    public MyThreadPool(int workersThreadCount, int maxNumberOfTask) {
        this.workQueue = new ArrayBlockingQueue<Runnable>(maxNumberOfTask);
        this.workThread = new ArrayList<MyThreadPoolWorker>(workersThreadCount);
        for (int i = 0; i < workersThreadCount; i++) {
            MyThreadPoolWorker myThread = new MyThreadPoolWorker(workQueue);
            workThread.add(myThread);
        }
    }

    public synchronized void submit(Runnable task) {
        workQueue.offer(task);
    }

    private synchronized void waitForAllTaskToComplete() {

        while (this.workQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void start() {
        System.out.println("Task Started");
        for (MyThreadPoolWorker threadPoolWorker : workThread) {
            Thread t = new Thread(threadPoolWorker);
            t.start();
        }


    }

    public synchronized void stop() {
        waitForAllTaskToComplete();
        for (MyThreadPoolWorker threadPoolWorker : workThread) {
            threadPoolWorker.doStop();
        }
        System.out.println("All Stopped");

    }

}
