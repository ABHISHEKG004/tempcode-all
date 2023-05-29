package JavaConcepts.BlockingQueue;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        // Instantiate an object of LinkedBlockingQueue
        // named lbdq
        BlockingQueue<Integer> lbdq
                = new LinkedBlockingQueue<Integer>();

        // Add elements using add()
        lbdq.add(22);
        lbdq.add(125);
        lbdq.add(723);
        lbdq.add(172);
        lbdq.add(100);

        // Print the elements of lbdq on the console
        System.out.println(
                "The LinkedBlockingQueue, lbdq contains:");
        System.out.println(lbdq);

        // To check if the deque contains 22
        if (lbdq.contains(22))
            System.out.println(
                    "The LinkedBlockingQueue, lbdq contains 22");
        else
            System.out.println("No such element exists");

        // Using element() to retrieve the head of the deque
        int head = lbdq.element();
        System.out.println("The head of lbdq: " + head);




        // Remove elements using remove();
        lbdq.remove(22);

        // Trying to remove an element
        // that doesn't exist
        // in the LinkedBlockingQueue
        lbdq.remove(1);




        // Print the elements of lbdq on the console
        System.out.println(
                "\nThe LinkedBlockingQueue, lbdq contains:");
        System.out.println(lbdq);




        // Create an iterator to traverse lbdq
        Iterator<Integer> lbdqIter = lbdq.iterator();

        // Print the elements of lbdq on to the console
        System.out.println("The LinkedBlockingQueue, lbdq contains:");

        for(int i = 0; i<lbdq.size(); i++)
        {
            System.out.print(lbdqIter.next() + " ");
        }
    }
}
