package com.hp.ps;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerCosumer {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();

        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        new Thread(p).start();
        new Thread(c).start();


    }


    private static class Producer implements Runnable {
        private Queue<Integer> q;


        public Producer(Queue<Integer> q) {
            this.q = q;
        }


        public void produce(int v) throws InterruptedException {
            synchronized (q) {
                q.add(v);
                notify();
                Thread.sleep(10);
            }

        }


        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    produce(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static class Consumer implements Runnable {
        private Queue<Integer> q;
        Object lock;

        public Consumer(Queue<Integer> q) {
            this.q = q;
        }


        public void poll() {
            synchronized (q) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }


        @Override
        public void run() {
            while (true) {
                poll();
            }
        }
    }

}
