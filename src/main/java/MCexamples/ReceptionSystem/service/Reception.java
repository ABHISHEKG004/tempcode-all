package MCexamples.ReceptionSystem.service;

import com.design.lowlevel.mine.ReceptionSystem.datastore.Datastore;
import com.design.lowlevel.mine.ReceptionSystem.model.Customer;

import java.util.ArrayList;

/**
 * Created by abhishek.gupt on 16/02/18.
 */
public class Reception implements Runnable{

    public String rid;

    public Reception(String s) {
        this.rid = s;

    }

    @Override
    public void run() {

            while (true) {
                Customer cust = Datastore.queue.poll();


                if (cust != null) {
                    int cid = cust.getCid();
                    String cname = cust.getCustName();
                    String caddress = cust.getAddress();
                    String query = cust.getQuery();

                    //proccess the customer process()

                    System.out.println("Serving Customer " + cname + " : by RECEPTION -> " + this.rid);

                    if (Datastore.hm.get(this.rid) == null) {

                        ArrayList<Customer> cu = new ArrayList<>();
                        cu.add(cust);
                        Datastore.hm.put(this.rid, cu);
                    }
                }
            }
    }
}
