package Threading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedOptimisticLockDemo2 {

    public static void main(String[] args) {

        StampedLock lock = new StampedLock();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable readtask = () -> {
            long stamp = lock.tryOptimisticRead();

            try {
                System.out.println("check Optimistic lock validity : " + lock.validate(stamp));
                Thread.sleep(2000);
                System.out.println("check Optimistic lock validity : " + lock.validate(stamp));
                Thread.sleep(2000);
                System.out.println("check Optimistic lock validity : " + lock.validate(stamp));

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }

        };
        executor.submit(readtask);

        Runnable writetask = () -> {
            long stamp = lock.writeLock();

            try {
                System.out.println("Acquired write lock");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("write completed");
                lock.unlockRead(stamp);
            }

        };

        executor.submit(writetask);
    }
}
