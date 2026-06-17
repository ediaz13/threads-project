package org.mogul;

public class ingState implements Runnable {
    public static Thread t1;
    public static void main(String[] args) {
        t1 = new Thread(new ingState());
        t1.start();
    }
    public void run() {
        Thread t2 = new Thread(new DemoingStateRunnable());
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}

class DemoingStateRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println(ingState.t1.getState());
    }
}