package Threading.locks;

//synchronized keyword in Java supports reentrant locking.
//Reentrant locking allows a thread to acquire the lock multiple times, as long as it releases the lock an equal
// number of times. This is useful in scenarios where a synchronized method or code block needs to call another
// synchronized method, and both methods require the same lock.

public class SynchronizedDemo2 {

    public static void main(String[] args) {

        DoubleLocks reentrantExample = new DoubleLocks();
        reentrantExample.outerMethod();

    }
}

class DoubleLocks {
    public synchronized void outerMethod() {
        System.out.println("outermethod");
        innerMethod();
    }

    public synchronized void innerMethod() {
        System.out.println("innerMethod");
        // Code inside innerMethod
    }
}