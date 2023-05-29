package MCexamples.ReceptionSystem.datastore;

import com.design.lowlevel.mine.ReceptionSystem.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by abhishek.gupt on 16/02/18.
 */
public class Datastore {

    public static ConcurrentLinkedQueue<Customer>  queue  = new ConcurrentLinkedQueue<>();
    public static HashMap<String, ArrayList<Customer>> hm = new HashMap<String , ArrayList<Customer>>();
}
