package org.mogul;

public class TimedingState {
    public static void main(String[] args) throws InterruptedException {
        DemoTimeingRunnable runnable= new DemoTimeingRunnable();
        Thread t1 = new Thread(runnable);
        t1.start();
        // The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
        Thread.sleep(1000);
        System.out.println(t1.getState());
    }
}
class DemoTimeingRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
