package Threading.locks;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();

        Executors.newSingleThreadExecutor().submit(() -> {
            lock.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {

            System.out.println("Lock check : " + lock.isLocked());
            System.out.println("Held by current thread : " + lock.isHeldByCurrentThread());

            boolean locked = lock.tryLock();

            System.out.println("Lock acquired : " + locked);
            System.out.println();

        }, 1 , 1 , TimeUnit.SECONDS);

    }
}
