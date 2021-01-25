package com.ds.mythreadpool;

import java.util.concurrent.BlockingQueue;

public class MyThreadPoolWorker implements Runnable {
    private  Thread thread;
    private BlockingQueue<Runnable> queue;
    private boolean stop;

    public MyThreadPoolWorker(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.thread=Thread.currentThread();
        while (!isStopped()) {
            try {
                Runnable r = queue.take();
                r.run();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": interrupted");

            } catch (Exception e) {

            }
        }
    }

    private boolean isStopped() {
        return stop;
    }

    public void doStop() {
        this.stop = true;
        thread.interrupt();
    }
}
