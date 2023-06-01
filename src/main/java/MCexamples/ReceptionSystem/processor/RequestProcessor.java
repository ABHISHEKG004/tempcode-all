package MCexamples.ReceptionSystem.processor;

import MCexamples.lowlevel.mine.ReceptionSystem.datastore.Datastore;
import MCexamples.lowlevel.mine.ReceptionSystem.model.Customer;

/**
 * Created by abhishek.gupt on 16/02/18.
 */
public class RequestProcessor {

    public static void processIncomingRequest(Customer customer){

        Datastore.queue.add(customer);

    }

}
