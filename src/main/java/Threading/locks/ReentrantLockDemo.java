package Threading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static int count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0;i<100;i++){
            executor.submit(ReentrantLockDemo::increment);
        }
        Thread.sleep(4000);
        System.out.println(count);
        executor.shutdown();
    }

    static void increment(){ //same as syncronized counterpart

        lock.lock();
        try {
            count += 1;
        } finally {
            lock.unlock();
        }
    }

}
