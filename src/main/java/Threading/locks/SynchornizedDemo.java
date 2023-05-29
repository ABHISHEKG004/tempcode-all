package Threading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchornizedDemo {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
//        IntStream.range(0,1000)
//                .forEach(i -> executor.submit(Myclass::increment));
        for(int i = 0;i<100;i++){
            executor.submit(SynchornizedDemo::increment);
        }
        Thread.sleep(4000);
        System.out.println(count);
    }

    static void increment(){
        count+=1;
    }

//    static synchronized void increment(){
//        count+=1;
//    }
}
