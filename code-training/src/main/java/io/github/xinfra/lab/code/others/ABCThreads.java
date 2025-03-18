package io.github.xinfra.lab.code.others;

import java.util.concurrent.TimeUnit;

public class ABCThreads {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Printer ap = new Printer("A", c, a);
        Printer bp = new Printer("B", a, b);
        Printer cp = new Printer("C", b, c);

        ap.start();
        bp.start();
        cp.start();

        synchronized (c) {
            c.notify();
        }
    }

    static class Printer extends Thread {

        public Printer(String name, Object waiter, Object notifier) {
            this.name = name;
            this.waiter = waiter;
            this.notifier = notifier;
        }

        private String name;
        private Object waiter;
        private Object notifier;

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (waiter) {
                        waiter.wait();
                    }
                    System.out.println(name);
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (notifier) {
                        notifier.notify();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
