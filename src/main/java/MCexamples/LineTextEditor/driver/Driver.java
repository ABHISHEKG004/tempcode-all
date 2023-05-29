package MCexamples.LineTextEditor.driver;

import com.design.lowlevel.mine.LineTextEditor.service.UiService;

/**
 * Created by abhishek.gupt on 08/01/18.
 */
public class Driver {

    public static void main(String[] args) {
        UiService ui = new UiService();
        ui.askUserForInput();
    }
}
