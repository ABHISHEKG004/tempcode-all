package MCexamples.ReceptionSystem.driver;

import com.design.lowlevel.mine.ReceptionSystem.model.Customer;
import com.design.lowlevel.mine.ReceptionSystem.processor.RequestProcessor;
import com.design.lowlevel.mine.ReceptionSystem.service.Reception;

/**
 * Created by abhishek.gupt on 16/02/18.
 */
public class Driver {

    public static void main(String[] args) {

        for(int i =0;i<4;i++){
            Thread thread = new Thread( new Reception("rid"+i));
            thread.start();
        }

        for(int i = 0;i<10;i++){
            RequestProcessor
                .processIncomingRequest( new Customer(i, "Customer_" + i, "Address_"+i, "Query_" + i));
        }

    }
}
