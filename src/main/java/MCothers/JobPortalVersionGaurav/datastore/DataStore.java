package MCothers.JobPortalVersionGaurav.datastore;

import MCothers.JobPortalVersionGaurav.model.User;

import java.util.HashMap;

/**
 * Created by gaurav.kum on 13/12/17.
 */
public class DataStore {
    private static HashMap<String, User> userDataStore = new HashMap<>();

    public static void addUser(User user) {
        userDataStore.put(user.getJobId(), user);
    }

    public static boolean deleteUser(String jobId) {
        if(userDataStore.get(jobId) != null) {
            userDataStore.remove(jobId);
            return true;
        }
        return false;
    }

    public static User getUser(String jobId) {
        if(userDataStore.get(jobId) != null) {
            return userDataStore.get(jobId);
        }
        return null;
    }

    public static boolean modifyUser(String jobId, User user) {
        if(userDataStore.get(jobId) != null) {
            userDataStore.remove(jobId);
            userDataStore.put(jobId, user);
            return true;
        } else {
            return false;
        }
    }
}
