package MCothers.JobPortalVersionGaurav.driver;

import com.design.lowlevel.others.JobPortalVersionGaurav.service.UIService;

/**
 * Created by gaurav.kum on 13/12/17.
 */
public class Driver {

    public static void main(String[] args) throws Exception {
        UIService ui = new UIService();
        ui.askUserForInput();
    }
}
