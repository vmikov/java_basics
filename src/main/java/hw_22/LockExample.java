package hw_22;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock lock = new ReentrantLock();

    public void method_1() {
        System.out.printf("\texecuting method_1 in thread %d\n", Thread.currentThread().getId());
    }

    public void method_2() {
        System.out.printf("\texecuting method_2 in thread %d\n", Thread.currentThread().getId());
    }

    public void method_3() {
        System.out.printf("\texecuting method_3 in thread %d\n", Thread.currentThread().getId());
    }

    public void algorithm() {
        final var TIME = 100;
        System.out.printf("Algorithm started in thread %d\n", Thread.currentThread().getId());
        lock.lock();
        try {
            Thread.sleep(TIME);
            method_1();
            Thread.sleep(TIME);
            method_2();
            Thread.sleep(TIME);
            method_3();
            Thread.sleep(TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.printf("Algorithm finished in thread %d\n", Thread.currentThread().getId());
    }
}
