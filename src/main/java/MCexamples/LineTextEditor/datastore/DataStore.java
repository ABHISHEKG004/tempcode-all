package MCexamples.LineTextEditor.datastore;


import java.util.ArrayList;

/**
 * Created by abhishek.gupt on 08/01/18.
 */
public class DataStore {

    private static ArrayList<String> userDataStore = new ArrayList<String> ();

    public static ArrayList<String> getUserDataStore() {
        return userDataStore;
    }

    public static void setUserDataStore(ArrayList<String> userDataStore) {
        DataStore.userDataStore = userDataStore;
    }
}
