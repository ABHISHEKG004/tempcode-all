package MCexamples.splitwise.Database;

import MCexamples.splitwise.models.Group;
import MCexamples.splitwise.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

public class Datastore {

  private static Map<String, User> users = new HashMap<String, User>();
  private static Map<String, Group> groups = new HashMap<String, Group>();

  public static void addUser(User user) {
    users.put(user.getId(), user);
  }

  public static boolean deleteUser(String userId) {
    if(users.get(userId) != null) {
      users.remove(userId);
      return true;
    }
    return false;
  }

  public static User getUser(String userId) {
    if(users.get(userId) != null) {
      return users.get(userId);
    }
    return null;
  }

  public static void addGroup(Group group) {
    groups.put(group.getId(), group);
  }

  public static Group geGroup(String groupId) {
    if(groups.get(groupId) != null) {
      return groups.get(groupId);
    }
    return null;
  }

}
